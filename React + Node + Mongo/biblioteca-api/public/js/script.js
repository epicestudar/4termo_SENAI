const apiUrl = "http://localhost:3000/livros";

// Carregar livros ao abrir a página
window.onload = function () {
  if (window.location.pathname.includes("index.html")) {
    buscarLivros();
  }
  if (window.location.pathname.includes("update.html")) {
    preencherFormularioAtualizacao();
  }
};

// Buscar e renderizar livros
function buscarLivros() {
  fetch(apiUrl)
    .then((response) => response.json())
    .then((livros) => {
      const tabelaCorpo = document.getElementById("livrosCorpo");
      tabelaCorpo.innerHTML = "";
      livros.forEach((livro) => {
        const linha = document.createElement("tr");
        linha.innerHTML = `
          <td>${livro._id}</td>
          <td>${livro.titulo}</td>
          <td>${livro.autor}</td>
          <td>${livro.ano}</td>
          <td>${livro.genero}</td>
          <td>
            <a href="update.html?id=${livro._id}" class="button">Atualizar</a>
            <button class="delete" onclick="deletarLivro('${livro._id}')">Deletar</button>
          </td>`;
        tabelaCorpo.appendChild(linha);
      });
    })
    .catch((error) => console.error("Erro ao buscar livros:", error));
}

// Deletar livro
function deletarLivro(id) {
  fetch(`${apiUrl}/${id}`, { method: "DELETE" })
    .then(() => buscarLivros())
    .catch((error) => console.error("Erro ao deletar livro:", error));
}

// Preencher formulário de atualização
function preencherFormularioAtualizacao() {
  const id = new URLSearchParams(window.location.search).get("id");
  if (id) {
    fetch(`${apiUrl}/${id}`)
      .then((response) => response.json())
      .then((livro) => {
        document.getElementById("livroId").value = livro._id;
        document.getElementById("titulo").value = livro.titulo;
        document.getElementById("autor").value = livro.autor;
        document.getElementById("ano").value = livro.ano;
        document.getElementById("genero").value = livro.genero;
      })
      .catch((error) => console.error("Erro ao buscar livro:", error));
  }
}

// Adicionar evento de submissão do formulário de atualização
document
  .getElementById("livroUP")
  ?.addEventListener("submit", function (event) {
    event.preventDefault();
    const id = document.getElementById("livroId").value;
    const livro = {
      titulo: document.getElementById("titulo").value,
      autor: document.getElementById("autor").value,
      ano: document.getElementById("ano").value,
      genero: document.getElementById("genero").value,
    };
    atualizarLivro(id, livro);
  });

// Atualizar livro
function atualizarLivro(id, livro) {
  fetch(`${apiUrl}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(livro),
  })
    .then(() => (window.location.href = "index.html"))
    .catch((error) => console.error("Erro ao atualizar livro:", error));
}

// Função para adicionar um novo livro
function adicionarLivro(livro) {
  fetch(apiUrl, {
    method: "POST", // Método POST é usado para criação
    headers: { "Content-Type": "application/json" }, // Define que os dados estão sendo enviados no formato JSON
    body: JSON.stringify(livro), // Converte o objeto 'livro' em uma string JSON para enviar no corpo da requisição
  })
    .then(() => (window.location.href = "index.html")) // Redireciona para a página 'index.html' após a adição bem-sucedida
    .catch((error) => console.error("Erro ao adicionar livro:", error)); // Lida com erros durante o processo de adição
}

document
  .getElementById("livroCad")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    // Captura os valores dos campos do formulário
    const titulo = document.getElementById("titulo").value;
    const autor = document.getElementById("autor").value;
    const ano = document.getElementById("ano").value;
    const genero = document.getElementById("genero").value;

    // Cria um objeto livro com os dados capturados do formulário
    const livro = { titulo, autor, ano, genero };
    adicionarLivro(livro);
  });