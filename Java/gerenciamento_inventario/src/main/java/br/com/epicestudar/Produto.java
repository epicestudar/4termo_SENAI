package br.com.epicestudar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private String categoria;
    private double preco;
}
