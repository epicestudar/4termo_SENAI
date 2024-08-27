import React, { useEffect, useState } from "react";
import axios from "axios";
import LivroCard from "./LivroCard";

const LivroList = () => {
  const [livros, setLivros] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:3000/livros")
      .then((response) => setLivros(response.data))
      .catch((error) => console.error("Erro ao buscar livros:", error));
  }, []);

  return (
    <div className="livro-list">
      {livros.map((livro) => (
        <LivroCard key={livro._id} livro={livro} />
      ))}
    </div>
  );
};

export default LivroList;
