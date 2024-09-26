package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    private String nomes[] = {"Maria", "João", "Pedro"};
    private List<String> nomesList;

    public ArraysAsList() {
        nomesList = new ArrayList<>(Arrays.asList(nomes));
    }

    public void addNome(String nome) {
        nomesList.add(nome);
        System.out.println("Nome adicionado com sucesso");
    }
}
