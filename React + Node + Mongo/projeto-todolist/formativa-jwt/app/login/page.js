"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import Header from "../components/Header";
import Footer from "../components/Footer";

export default function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const router = useRouter();

  const handleLogin = async (e) => {
    e.preventDefault();
    const response = await fetch("/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, senha }),
    });

    const data = await response.json();
    if (response.ok) {
      localStorage.setItem("token", data.token);
      router.push("/todos");
    } else {
      alert("Credenciais inválidas");
    }
  };

  return (
    <div>
      <Header />
      <form onSubmit={handleLogin}>
        <h2>Login</h2>
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Senha"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
        />
        <button type="submit">Login</button>
      </form>
      <Footer />
      <style jsx>{`
        div {
          display: flex;
          flex-direction: column;
          justify-content: space-between;
          height: 100vh;
        }
        form {
          display: flex;
          flex-direction: column;
          align-items: center;
          margin: auto;
          padding: 20px;
          background-color: #f7f7f7;
          border-radius: 10px;
          width: 300px;
        }
        h2 {
          margin-bottom: 20px;
        }
        input {
          margin: 10px 0;
          padding: 10px;
          width: 100%;
          border: 1px solid #ccc;
          border-radius: 5px;
        }
        button {
          background-color: #333;
          color: #fff;
          padding: 10px;
          width: 100%;
          border: none;
          border-radius: 5px;
          cursor: pointer;
        }
        button:hover {
          background-color: #555;
        }
      `}</style>
    </div>
  );
}
