package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo() {
        nomes = new HashSet<>();
    }

    public void addNome(String nome) {
        try {
            nomes.add(nome);
            System.out.println(nomes.hashCode());
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

    
}
