"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import Header from "../components/Header";
import Footer from "../components/Footer";

export default function Register() {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const router = useRouter();

  const handleRegister = async (e) => {
    e.preventDefault();
    const response = await fetch("/api/auth/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ nome, email, senha }),
    });

    if (response.ok) {
      router.push("/login");
    } else {
      alert("Erro ao registrar");
    }
  };

  return (
    <div>
      <Header />
      <form onSubmit={handleRegister}>
        <h2>Registrar</h2>
        <input
          type="text"
          placeholder="Usuário"
          value={nome}
          onChange={(e) => setNome(e.target.value)}
        />
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
        <button type="submit">Registrar</button>
      </form>
      <Footer />
      <style jsx>{`
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
