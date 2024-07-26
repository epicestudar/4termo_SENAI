package com;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import br.com.epicestudar.Inventario;
import br.com.epicestudar.Produto;

public class InventarioTeste {
    private Inventario inventario;

    @Before
    public void setup() {
        inventario = new Inventario();
    }

    @Test
    public void testeAdicionar() {
        Produto produto = new Produto(1, "teste", 10, "teste", 99.9);
        inventario.adicionar(produto);
        List<Produto> lista = inventario.listar();
        assertEquals(1, lista.size());
    }

    @Test
    public void testeRemover() {
        testeAdicionar();
        inventario.remover(1);
        List<Produto> lista = inventario.listar();
        assertEquals(0, lista.size());
    }

    @Test
    public void testeAtualizar() {
        testeAdicionar();
        inventario.atualizar(1, 20, 45);
        List<Produto> lista = inventario.listar();
        Produto produtoAtualizado = lista.get(0);
        assertEquals(20, produtoAtualizado.getQuantidade());
        assertEquals(45, produtoAtualizado.getPreco(), 0);
    }


}
