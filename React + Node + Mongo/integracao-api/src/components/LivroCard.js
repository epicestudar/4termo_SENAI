import React from "react";

const LivroCard = ({ livro }) => {
  return (
    <div className="livro-card">
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

export default LivroCard;
