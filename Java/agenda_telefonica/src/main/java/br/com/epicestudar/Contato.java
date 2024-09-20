package br.com.epicestudar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contato {
    private String nome;
    private String telefone;


    @Override
    public String toString() {
        return "Nome: " + nome + ", telefone" + telefone;
    }
}
