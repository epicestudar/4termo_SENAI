package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }

    public void addNome(String nome) {
        try {
            nomes.add(nome);
            System.out.println(nomes.lastIndexOf(nome));
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void listarNomes() {
        System.out.println(nomes);
    }

    public void removerNomes(String nome) {
        try {
            nomes.remove(nome);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void modificarNome(String nomeAntigo, String nomeNovo) {
        try {
            int index = nomes.indexOf(nomeAntigo);
            nomes.set(index, nomeNovo);
            System.out.println("Nome alterado com sucesso");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
