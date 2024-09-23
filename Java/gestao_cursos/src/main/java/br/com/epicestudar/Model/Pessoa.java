package br.com.epicestudar.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Pessoa {
    private String nome;
    private String email;
    private String cpf;

    public String exibirInformacoes() {
        return "Nome: " + nome + ", Email: " + email + ", CPF: " + cpf;
    }
}
