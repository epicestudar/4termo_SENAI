import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

const LivroDetalhes = () => {
  const { id } = useParams();
  const [livro, setLivro] = useState(null);

  useEffect(() => {
    axios
      .get(`http://localhost:3000/livros/${id}`)
      .then((response) => setLivro(response.data))
      .catch((error) => console.error("Erro ao buscar livro:", error));
  }, [id]);

  if (!livro) return <p>Carregando...</p>;

  return (
    <div className="livro-detalhes">
      <h2>{livro.titulo}</h2>
      <p>
        <strong>Autor:</strong> {livro.autor}
      </p>
      <p>
        <strong>Ano:</strong> {livro.ano}
      </p>
      <p>
        <strong>Gênero:</strong> {livro.genero}
      </p>
    </div>
  );
};

export default LivroDetalhes;
