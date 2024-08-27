import React, { useState } from "react";
import axios from "axios";

const LivroForm = ({ livroAtual, onSave }) => {
  const [livro, setLivro] = useState(
    livroAtual || { titulo: "", autor: "", ano: "", genero: "" }
  );

  const handleChange = (e) => {
    const { name, value } = e.target;
    setLivro({ ...livro, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const request = livro._id ? axios.put : axios.post;
    const url = livro._id
      ? `http://localhost:3000/livros/${livro._id}`
      : "http://localhost:3000/livros";

    request(url, livro)
      .then((response) => onSave(response.data))
      .catch((error) => console.error("Erro ao salvar livro:", error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        name="titulo"
        value={livro.titulo}
        onChange={handleChange}
        placeholder="Título"
      />
      <input
        name="autor"
        value={livro.autor}
        onChange={handleChange}
        placeholder="Autor"
      />
      <input
        name="ano"
        value={livro.ano}
        onChange={handleChange}
        placeholder="Ano"
      />
      <input
        name="genero"
        value={livro.genero}
        onChange={handleChange}
        placeholder="Gênero"
      />
      <button type="submit">Salvar</button>
    </form>
  );
};

export default LivroForm;
