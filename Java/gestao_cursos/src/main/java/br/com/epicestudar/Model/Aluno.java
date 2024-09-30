package br.com.epicestudar.Model;

import br.com.epicestudar.Interface.Avaliavel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa implements Avaliavel{
    private String nMatricula;
    private double nota;

    public Aluno(String nome, String email, String cpf, String nMatricula, double nota) {
        super(nome, email, cpf);
        this.nMatricula = nMatricula;
        this.nota = 0.0;
    }

    // polimorfismo -- sobreescrever o método
    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + ", Matrícula: " + nMatricula + ", Nota: " + nota;
    }

    @Override
    public void avaliarDesempenho() {
        if(nota >= 7) {
            System.out.println("Aluno aprovado");
        } else if(nota >=5 && nota< 7) {
            System.out.println("Aluno de recuperação");
        } else {
            System.out.println("Aluno reprovado");
        }
    }
}
