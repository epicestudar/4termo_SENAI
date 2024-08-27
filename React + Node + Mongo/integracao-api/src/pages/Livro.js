import React, { useState, useEffect } from "react";
import axios from "axios";

const Livros = () => {
  const [livros, setLivros] = useState([]);
  const [novoLivro, setNovoLivro] = useState({
    titulo: "",
    autor: "",
    ano: "",
    genero: "",
  });

  // Função para listar todos os livros
  const listarLivros = async () => {
    try {
      const response = await axios.get("http://localhost:3000/livros");
      setLivros(response.data);
    } catch (error) {
      console.error("Erro ao listar livros", error);
    }
  };

  // Função para criar um novo livro
  const criarLivro = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:3000/livros",
        novoLivro
      );
      setLivros([...livros, response.data]);
      setNovoLivro({ titulo: "", autor: "", ano: "", genero: "" });
    } catch (error) {
      console.error("Erro ao criar livro", error);
    }
  };

  // Função para deletar um livro
  const deletarLivro = async (id) => {
    try {
      await axios.delete(`http://localhost:3000/livros/${id}`);
      setLivros(livros.filter((livro) => livro._id !== id));
    } catch (error) {
      console.error("Erro ao deletar livro", error);
    }
  };

  useEffect(() => {
    listarLivros();
  }, []);

  return (
    <div>
      <h1>Gerenciamento de Livros</h1>

      <form onSubmit={criarLivro}>
        <input
          type="text"
          placeholder="Título"
          value={novoLivro.titulo}
          onChange={(e) =>
            setNovoLivro({ ...novoLivro, titulo: e.target.value })
          }
        />
        <input
          type="text"
          placeholder="Autor"
          value={novoLivro.autor}
          onChange={(e) =>
            setNovoLivro({ ...novoLivro, autor: e.target.value })
          }
        />
        <input
          type="number"
          placeholder="Ano"
          value={novoLivro.ano}
          onChange={(e) => setNovoLivro({ ...novoLivro, ano: e.target.value })}
        />
        <input
          type="text"
          placeholder="Gênero"
          value={novoLivro.genero}
          onChange={(e) =>
            setNovoLivro({ ...novoLivro, genero: e.target.value })
          }
        />
        <button type="submit">Adicionar Livro</button>
      </form>

      <h2>Lista de Livros</h2>
      <ul>
        {livros.map((livro) => (
          <li key={livro._id}>
            {livro.titulo} - {livro.autor} ({livro.ano}) - {livro.genero}
            <button onClick={() => deletarLivro(livro._id)}>Deletar</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Livros;
