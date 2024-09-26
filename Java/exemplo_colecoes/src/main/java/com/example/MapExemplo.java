package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String, Integer> nomesIdades;

    public MapExemplo() {
        nomesIdades = new HashMap<>();
    }

    public void addNomeIdade(String nome, int idade) {
        nomesIdades.put(nome, idade);
        System.out.println(nomesIdades.get(nome));
    }

    public void listarNomesIdade() {
        System.out.println(nomesIdades);
    }

    public void removerNomeIdade(String nome) {
        nomesIdades.remove(nome);
    }

    public void modificarValor(String nome, int novaIdade) {
        nomesIdades.replace(nome, novaIdade);
    }

    
 }
