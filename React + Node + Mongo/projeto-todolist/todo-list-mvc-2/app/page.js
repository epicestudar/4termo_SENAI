"use client";

import { useState, useEffect } from "react";
import styles from "./page.module.css";

export default function Home() {
  const [todos, setTodos] = useState([]);
  const [newTodoTitle, setNewTodoTitle] = useState("");
  const [newTodoDescription, setNewTodoDescription] = useState("");

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await fetch("/api/todos");
      if (!response.ok) {
        throw new Error("Erro ao buscar todos");
      }
      const data = await response.json();
      setTodos(data.data);
    } catch (error) {
      console.error("Erro ao buscar todos:", error);
    }
  };

  const addTodo = async () => {
    const response = await fetch("/api/todos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title: newTodoTitle,
        description: newTodoDescription,
      }),
    });
    const data = await response.json();
    setTodos([...todos, data.data]);
    setNewTodoTitle("");
    setNewTodoDescription("");
  };

  const deleteTodo = async (id) => {
    await fetch(`/api/todos/${id}`, {
      method: "DELETE",
    });
    setTodos(todos.filter((todo) => todo._id !== id));
  };

  const updateTodo = async (id, updatedData) => {
    const response = await fetch(`/api/todos/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(updatedData),
    });
    await response.json();
    fetchTodos();
  };

  const handleStatusChange = (id, newStatus) => {
    updateTodo(id, { status: newStatus });
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>To-Do List</h1>

      {/* Input para o título */}
      <input
        type="text"
        className={styles.inputText}
        placeholder="Título da tarefa"
        value={newTodoTitle}
        onChange={(e) => setNewTodoTitle(e.target.value)}
      />

      {/* Input para a descrição */}
      <textarea
        className={styles.inputText}
        placeholder="Descrição da tarefa"
        value={newTodoDescription}
        onChange={(e) => setNewTodoDescription(e.target.value)}
      />

      <button className={styles.button} onClick={addTodo}>
        Adicionar Tarefa
      </button>

      <ul className={styles.list}>
        {todos.map((todo) => (
          <li className={styles.listItem} key={todo._id}>
            <strong>{todo.title}</strong> -{" "}
            {todo.description ? todo.description : "Sem descrição"}
            {/* Select para mudar o status */}
            <select
              value={todo.status}
              onChange={(e) => handleStatusChange(todo._id, e.target.value)}
              className={styles.select}
            >
              <option value="A fazer">A fazer</option>
              <option value="Fazendo">Fazendo</option>
              <option value="Feito">Feito</option>
            </select>
            <button
              className={styles.deleteButton}
              onClick={() => deleteTodo(todo._id)}
            >
              Excluir
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}
