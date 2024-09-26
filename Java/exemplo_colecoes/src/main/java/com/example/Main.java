package com.example;

public class Main {
    public static void main(String[] args) {
        ListExemplo list = new ListExemplo();
        list.addNome("Maria");
        list.addNome("João");
        list.addNome("Vinicius");
        list.listarNomes();
        list.modificarNome("Vinicius", "Vinicius 2");
        list.listarNomes();
        list.removerNomes("Maria");
        list.listarNomes();
    }
}