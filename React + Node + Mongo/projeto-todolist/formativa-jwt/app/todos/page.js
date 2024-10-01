"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import Header from "../components/Header";
import Footer from "../components/Footer";

export default function TodoPage() {
  const [todos, setTodos] = useState([]);
  const [newTitulo, setNewTitulo] = useState("");
  const [newDescricao, setNewDescricao] = useState("");
  const [newStatus, setNewStatus] = useState("Pendente");
  const router = useRouter();

  useEffect(() => {
    const fetchTodos = async () => {
      const token = localStorage.getItem("token");
      if (!token) {
        router.push("/login");
        return;
      }

      const response = await fetch("/api/todos", {
        headers: { Authorization: `Bearer ${token}` },
      });

      if (response.ok) {
        const data = await response.json();
        setTodos(data.todos);
      } else {
        router.push("/login");
      }
    };

    fetchTodos();
  }, [router]);

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
    setNewStatus("Pendente");
  };

  const deleteTodo = async (id) => {
    const token = localStorage.getItem("token");
    await fetch(`/api/todos?id=${id}`, {
      method: "DELETE",
      headers: { Authorization: `Bearer ${token}` },
    });

    setTodos(todos.filter((todo) => todo._id !== id));
  };

  return (
    <div>
      <Header />
      <h1>To-Do List</h1>
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
        <option value="Concluído">Concluído</option>
      </select>
      <button onClick={addTodo}>Adicionar Tarefa</button>

      <ul>
        {todos.map((todo) => (
          <li key={todo._id}>
            <h3>{todo.titulo}</h3>
            <p>{todo.descricao}</p>
            <button onClick={() => deleteTodo(todo._id)}>Deletar</button>
          </li>
        ))}
      </ul>
      <Footer />
      <style jsx>{`
        div {
          display: flex;
          flex-direction: column;
          justify-content: space-between;
          height: 100vh;
        }
        h1 {
          text-align: center;
          margin: 20px 0;
        }
        input,
        select {
          margin: 10px;
          padding: 10px;
          border-radius: 5px;
          border: 1px solid #ccc;
        }
        button {
          margin: 10px;
          padding: 10px;
          background-color: #333;
          color: #fff;
          border: none;
          border-radius: 5px;
          cursor: pointer;
        }
        button:hover {
          background-color: #555;
        }
        ul {
          list-style: none;
          padding: 0;
        }
        li {
          background-color: #f7f7f7;
          padding: 15px;
          margin: 10px;
          border-radius: 10px;
          box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
      `}</style>
    </div>
  );
}
