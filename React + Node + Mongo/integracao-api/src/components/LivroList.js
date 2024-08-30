import React from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const LivroList = ({ livros, setLivros }) => {
  const navigate = useNavigate();

  const deletarLivro = async (id) => {
    try {
      await axios.delete(`http://localhost:3000/livros/${id}`);
      setLivros(livros.filter((livro) => livro._id !== id));
    } catch (error) {
      console.error("Erro ao deletar livro", error);
    }
  };

  return (
    <ul>
      {livros.map((livro) => (
        <li key={livro._id}>
          {livro.titulo} - {livro.autor} ({livro.ano}) - {livro.genero}
          <button onClick={() => navigate(`/editar-livro/${livro._id}`)}>
            Editar
          </button>
          <button onClick={() => deletarLivro(livro._id)}>Deletar</button>
        </li>
      ))}
    </ul>
  );
};

export default LivroList;
