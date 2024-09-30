package br.com.epicestudar.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor extends Pessoa{
    private double salario;

   public Professor(String nome, String email, String cpf, double salario) {
    super(nome, email, cpf);
    this.salario = salario;
   }

   @Override
   public String exibirInformacoes() {
    return super.exibirInformacoes() + "Salário: " + salario;
   }
}
