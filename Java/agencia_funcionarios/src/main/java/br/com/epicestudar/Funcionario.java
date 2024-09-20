package br.com.epicestudar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Funcionario {
    private String nome;
    private int idade;
    private double salario;

    @Override
    public String toString() {
        return "Nome: " + nome + ", idade" + idade + ", salario: " + salario;
    }
}
