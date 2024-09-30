package com.example;
import java.util.*;
import java.util.stream.Collectors;

public class Vendas {
    private Map<String, List<Produto>> vendasCPF;

    public Vendas() {
        vendasCPF =  new HashMap<>();
    }

    // métodos 

    // cadastrar venda
    public void cadastroVenda(String cpf, Produto produto) {
        for (String cpfUsuario : vendasCPF.keySet()) {
            if(cpfUsuario.equalsIgnoreCase(cpf)) {
                List<Produto> produtosCPF = vendasCPF.get(cpf);
                produtosCPF.add(produto);
                vendasCPF.put(cpf, produtosCPF);
                return;
            }
        }
        List<Produto> produtosCPFVazio = new ArrayList<>();
        produtosCPFVazio.add(produto);
        vendasCPF.put(cpf, produtosCPFVazio);
    }

    // listar produtos de um cpf
    public List<Produto> listarProdutos(String cpf) {
        List<Produto> listaCPF = vendasCPF.getOrDefault(cpf, Collections.emptyList());
        return listaCPF;
    }

    // listar com filtro (stream)
    public List<Produto> listarComFiltro(String cpf, double valorMinimo) throws Exception{
        List<Produto> listaCpfFiltro = vendasCPF.getOrDefault(cpf,  Collections.emptyList());
        if (listaCpfFiltro.isEmpty()) {
            throw new Exception("CPF não encontrado");
        } else{
            List<Produto> resultado = listaCpfFiltro.stream().filter(p->p.getPreco()>=valorMinimo).collect(Collectors.toList());
            return resultado;
        }
    }
}
