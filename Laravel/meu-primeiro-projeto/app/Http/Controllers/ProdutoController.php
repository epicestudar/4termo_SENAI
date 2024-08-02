<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;
use App\Models\Produto;

class ProdutoController extends Controller
{
    // Exibe a lista de produtos
    public function index()
    {
        $produtos = Produto::all();
        return view('produtos', compact('produtos'));
    }

    // Exibe o formulário para criar um novo produto
    public function create()
    {
        return view('produtos.create');
    }

    // Armazena um novo produto no banco de dados
    public function store(Request $request)
    {
        $request->validate([
            'nome' => 'required',
            'descricao' => 'required',
            'preco' => 'required|decimal',
            'quantidade' => 'required|integer',
        ]);

        Produto::create($request->all());

        return redirect()->route('produtos.index')->
        with('success', 'Produto criado com sucesso.');
    }

    // Exibe um produto específico
    public function show(Produto $produto)
    {
        return view('produtos.show', compact('produto'));
    }

    // Exibe o formulário para editar um produto existente
    public function edit(Produto $produto)
    {
        return view('produtos.edit', compact('produto'));
    }

    // Atualiza um produto existente no banco de dados
    public function update(Request $request, Produto $produto)
    {
        $request->validate([
            'nome' => 'required',
            'descricao' => 'required',
            'preco' => 'required|numeric',
            'quantidade' => 'required|integer',
        ]);

        $produto->update($request->all());

        return redirect()->route('produtos.index')->with('success', 'Produto atualizado com sucesso.');
    }

    // Remove um produto do banco de dados
    public function destroy(Produto $produto)
    {
        $produto->delete();

        return redirect()->route('produtos.index')->with('success', 'Produto excluído com sucesso.');
    }
}