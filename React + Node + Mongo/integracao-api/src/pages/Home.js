import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import LivroList from "../components/LivroList";
import axios from "axios";

const Home = () => {
  const [livros, setLivros] = useState([]);
  const navigate = useNavigate();

  const listarLivros = async () => {
    try {
      const response = await axios.get("http://localhost:3000/livros");
      setLivros(response.data);
    } catch (error) {
      console.error("Erro ao listar livros", error);
    }
  };

  useEffect(() => {
    listarLivros();
  }, []);

  return (
    <div>
      <h1>Livros Disponíveis</h1>
      <button onClick={() => navigate("/novo-livro")}>Adicionar Livro</button>
      <LivroList livros={livros} setLivros={setLivros} />
    </div>
  );
};

export default Home;
