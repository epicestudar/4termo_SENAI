package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    private String nome;
    private double preco;

    @Override
    public String toString() {
        return "Nome: " + nome + ", preço: " + preco;
    }
}
