"use client";

import { useState, useEffect } from "react";
import styles from "./page.module.css";

export default function Home() {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState("");

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
      body: JSON.stringify({ title: newTodo }),
    });
    const data = await response.json();
    setTodos([...todos, data.data]);
    setNewTodo("");
  };

  const deleteTodo = async (id) => {
    await fetch(`/api/todos/${id}`, {
      method: "DELETE",
    });
    setTodos(todos.filter((todo) => todo._id !== id));
  };

  const updateTodo = async (id, status) => {
    const response = await fetch(`/api/todos/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ completed: !status }),
    });
    await response.json();
    fetchTodos();
  };

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>To-Do List</h1>
      <input
        type="text"
        className={styles.inputText}
        value={newTodo}
        onChange={(e) => setNewTodo(e.target.value)}
      />
      <button className={styles.button} onClick={addTodo}>
        Adicionar Tarefa
      </button>
      <ul className={styles.list}>
        {todos.map((todo) => (
          <li className={styles.listItem} key={todo._id}>
            <input
              type="checkbox"
              className={styles.checkbox}
              checked={todo.completed}
              onChange={() => updateTodo(todo._id, todo.completed)}
            />
            {todo.title} - {todo.completed ? "Concluído" : "Pendente"}
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
