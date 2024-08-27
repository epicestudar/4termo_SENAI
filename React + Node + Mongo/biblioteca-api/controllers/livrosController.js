const Livro = require('../models/livro');

exports.criarLivro = async (req, res) => {
  const livro = new Livro({
    titulo: req.body.titulo,
    autor: req.body.autor,
    ano: req.body.ano,
    genero: req.body.genero,
  });

  try {
    // Salva o novo livro no banco de dados
    const novoLivro = await livro.save();
    // Retorna o livro criado com status 201 (Criado)
    res.status(201).json(novoLivro);
  } catch (err) {
    // Em caso de erro, retorna uma mensagem de erro com status 400 (Bad Request)
    res.status(400).json({ message: err.message });
  }
};

// Listar todos os livros
exports.listarLivros = async (req, res) => {
  try {
    // Busca todos os livros no banco de dados
    const livros = await Livro.find();
    // Retorna a lista de livros
    res.json(livros);
  } catch (err) {
    // Em caso de erro, retorna uma mensagem de erro com status 500 (Internal Server Error)
    res.status(500).json({ message: err.message });
  }
};

// Buscar um livro por ID
exports.buscarLivroPorId = async (req, res) => {
  try {
    // Busca um livro pelo ID recebido nos parâmetros da requisição
    const livro = await Livro.findById(req.params.id);
    if (livro == null) {
      // Se o livro não for encontrado, retorna status 404 (Não Encontrado)
      return res.status(404).json({ message: "Livro não encontrado" });
    }
    // Retorna o livro encontrado
    res.json(livro);
  } catch (err) {
    // Em caso de erro, retorna uma mensagem de erro com status 500 (Internal Server Error)
    res.status(500).json({ message: err.message });
  }
};

// Atualizar um livro por ID
exports.atualizarLivro = async (req, res) => {
  try {
    // Busca o livro pelo ID
    const livro = await Livro.findById(req.params.id);
    if (livro == null) {
      // Se o livro não for encontrado, retorna status 404 (Não Encontrado)
      return res.status(404).json({ message: "Livro não encontrado" });
    }

    // Verifica quais campos foram enviados na requisição e os atualiza
    if (req.body.titulo != null) {
      livro.titulo = req.body.titulo;
    }
    if (req.body.autor != null) {
      livro.autor = req.body.autor;
    }
    if (req.body.ano != null) {
      livro.ano = req.body.ano;
    }
    if (req.body.genero != null) {
      livro.genero = req.body.genero;
    }

    // Salva o livro atualizado no banco de dados
    const livroAtualizado = await livro.save();
    // Retorna o livro atualizado
    res.json(livroAtualizado);
  } catch (err) {
    // Em caso de erro, retorna uma mensagem de erro com status 400 (Bad Request)
    res.status(400).json({ message: err.message });
  }
};

// Deletar um livro por ID
exports.deletarLivro = async (req, res) => {
  try {
    // Busca o livro pelo ID
    const livro = await Livro.findById(req.params.id);
    if (livro == null) {
      // Se o livro não for encontrado, retorna status 404 (Não Encontrado)
      return res.status(404).json({ message: "Livro não encontrado" });
    }

    // Remove o livro do banco de dados
    await livro.deleteOne({_id:req.params.id})
    // Retorna uma mensagem de sucesso
    res.json({ message: "Livro deletado com sucesso" });
  } catch (err) {
    // Em caso de erro, retorna uma mensagem de erro com status 500 (Internal Server Error)
    res.status(500).json({ message: err.message });
  }
};