import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

const LivroForm = () => {
  const { id } = useParams();
  const [livro, setLivro] = useState({
    titulo: "",
    autor: "",
    ano: "",
    genero: "",
  });
  const navigate = useNavigate();
  const [editando, setEditando] = useState(false);

  useEffect(() => {
    if (id) {
      setEditando(true);
      axios
        .get(`http://localhost:3000/livros/${id}`)
        .then((response) => setLivro(response.data))
        .catch((error) => console.error("Erro ao buscar livro:", error));
    }
  }, [id]);

  const salvarLivro = async (e) => {
    e.preventDefault();
    try {
      if (editando) {
        await axios.put(`http://localhost:3000/livros/${id}`, livro);
      } else {
        await axios.post("http://localhost:3000/livros", livro);
      }
      navigate("/");
    } catch (error) {
      console.error("Erro ao salvar livro", error);
    }
  };

  return (
    <div>
      <h1>{editando ? "Editar Livro" : "Adicionar Novo Livro"}</h1>
      <form onSubmit={salvarLivro}>
        <input
          type="text"
          placeholder="Título"
          value={livro.titulo}
          onChange={(e) => setLivro({ ...livro, titulo: e.target.value })}
        />
        <input
          type="text"
          placeholder="Autor"
          value={livro.autor}
          onChange={(e) => setLivro({ ...livro, autor: e.target.value })}
        />
        <input
          type="number"
          placeholder="Ano"
          value={livro.ano}
          onChange={(e) => setLivro({ ...livro, ano: e.target.value })}
        />
        <input
          type="text"
          placeholder="Gênero"
          value={livro.genero}
          onChange={(e) => setLivro({ ...livro, genero: e.target.value })}
        />
        <button type="submit">
          {editando ? "Salvar Alterações" : "Adicionar Livro"}
        </button>
      </form>
    </div>
  );
};

export default LivroForm;
