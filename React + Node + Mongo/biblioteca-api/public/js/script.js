// URL da API (substitua pela URL correta se necessário)
const apiUrl = "http://localhost:3000/livros";

// Função para buscar os livros na API e renderizar na tabela
function buscarLivros() {
  fetch(apiUrl)
    .then((response) => response.json()) // Converte a resposta para JSON
    .then((livros) => {
      const tabelaCorpo = document.getElementById("livrosCorpo");
      tabelaCorpo.innerHTML = ""; // Limpa a tabela antes de renderizar

      // Itera sobre os livros e cria uma linha para cada um
      livros.forEach((livro) => {
        const linha = document.createElement("tr");

        // Cria as células da linha
        const idCelula = document.createElement("td");
        idCelula.textContent = livro._id; // Ou livro.id_livro dependendo da estrutura

        const tituloCelula = document.createElement("td");
        tituloCelula.textContent = livro.titulo;

        const autorCelula = document.createElement("td");
        autorCelula.textContent = livro.autor;

        const anoCelula = document.createElement("td");
        anoCelula.textContent = livro.ano;

        const generoCelula = document.createElement("td");
        generoCelula.textContent = livro.genero;

        //Adicionar botões de ação na célula
        const acoesCelula = document.createElement("td");
        const updateButton = document.createElement("a");
        updateButton.textContent = "Atualizar";
        updateButton.classList.add("button");
        updateButton.href = `update.html?id=${livro._id}`;

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Deletar";
        deleteButton.classList.add("delete");
        deleteButton.onclick = () => deletarLivro(livro._id);

        acoesCelula.appendChild(updateButton);
        acoesCelula.appendChild(deleteButton);

        // Adiciona as células na linha
        linha.appendChild(idCelula);
        linha.appendChild(tituloCelula);
        linha.appendChild(autorCelula);
        linha.appendChild(anoCelula);
        linha.appendChild(generoCelula);
        linha.appendChild(acoesCelula);

        // Adiciona a linha na tabela
        tabelaCorpo.appendChild(linha);
      });
    })
    .catch((error) => console.error("Erro ao buscar livros:", error)); // Loga um erro em caso de falha
}

// Chama a função para buscar e renderizar os livros ao carregar a página
window.onload = buscarLivros;

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

// Preenche o formulário de atualização com os dados do livro existente
if (window.location.pathname.includes("update.html")) {
  const id = new URLSearchParams(window.location.search).get("id");
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
