"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function TodoPage() {
  const [todos, setTodos] = useState([]);
  const [newTitulo, setNewTitulo] = useState("");
  const [newDescricao, setNewDescricao] = useState("");
  const [newStatus, setNewStatus] = useState("Pendente");
  const router = useRouter();

  // Fetch todos ao carregar a página
  useEffect(() => {
    const fetchTodos = async () => {
      const token = localStorage.getItem("token");
      if (!token) {
        router.push("/login"); // Redireciona para login se o usuário não estiver autenticado
        return;
      }

      const response = await fetch("/api/todos", {
        headers: {
          Authorization: `Bearer ${token}`, // Envia o token no header da requisição
        },
      });

      if (response.ok) {
        const data = await response.json();
        setTodos(data.todos);
      } else {
        router.push("/login"); // Redireciona para login se houver erro
      }
    };

    fetchTodos();
  }, [router]);

  // Adiciona nova tarefa
  const addTodo = async () => {
    const token = localStorage.getItem("token");
    const response = await fetch("/api/todos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({
        titulo: newTitulo,
        descricao: newDescricao,
        status: newStatus,
      }),
    });

    const data = await response.json();
    setTodos([...todos, data.todo]);
    setNewTitulo("");
    setNewDescricao("");
    setNewStatus("Pendente"); // Reseta o status para Pendente
  };

  // Deleta uma tarefa
  const deleteTodo = async (id) => {
    const token = localStorage.getItem("token");
    await fetch(`/api/todos?id=${id}`, {
      method: "DELETE",
      headers: {
        Authorization: `Bearer ${token}`,
      },
    });

    setTodos(todos.filter((todo) => todo._id !== id));
  };

  return (
    <div>
      <h1>To-Do List</h1>
      {/* Formulário para adicionar nova tarefa */}
      <input
        type="text"
        value={newTitulo}
        onChange={(e) => setNewTitulo(e.target.value)}
        placeholder="Título da tarefa"
      />
      <input
        type="text"
        value={newDescricao}
        onChange={(e) => setNewDescricao(e.target.value)}
        placeholder="Descrição da tarefa"
      />
      <select value={newStatus} onChange={(e) => setNewStatus(e.target.value)}>
        <option value="Pendente">Pendente</option>
        <option value="Em progresso">Em progresso</option>
        <option value="Concluído">Concluído</option>
      </select>
      <button onClick={addTodo}>Adicionar Tarefa</button>

      {/* Lista de tarefas */}
      <ul>
        {todos.map((todo) => (
          <li key={todo._id}>
            <strong>{todo.titulo}</strong> - {todo.descricao} [{todo.status}]
            <button onClick={() => deleteTodo(todo._id)}>Excluir</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
