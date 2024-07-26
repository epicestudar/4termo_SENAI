package br.com.epicestudar;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Produto> list;

    public Inventario() {
        list = new ArrayList<>();
    }

    public void adicionar(Produto produto) {
        list.add(produto);
    }

    public void remover(int id) {
        list.removeIf(produto -> produto.getId()==id);
    }

    public void atualizar(int id, int quantidade, double preco) {
        for (Produto produto : list) {
            if(produto.getId() == id) {
                produto.setQuantidade(quantidade);
                produto.setPreco(preco);
                break;
            }
        }
    }

    public List<Produto> listar() {
        return new ArrayList<>(list);
    }
}
