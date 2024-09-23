package br.com.epicestudar.Controller;

import java.util.*;

import br.com.epicestudar.Model.Aluno;
import br.com.epicestudar.Model.Pessoa;
import br.com.epicestudar.Model.Professor;
import javax.swing.JOptionPane;

public class PessoaController {
    private List<Aluno> alunos;
    private List<Professor> professores;

    public PessoaController() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
    }

    public void addPessoa(Professor professor, Aluno aluno) {
        int operacao = 0;
        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog(
                        "\n" + "1. Cadastrar Aluno \n" + "2. Cadastrar Professor \n" + "3. Sair"));
            } catch (Exception e) {
                System.err.println(e);
                operacao = 0;
            }

            switch (operacao) {
                case 1:
                    // String nome = JOptionPane.showInputDialog("Insira o nome:");
                    // String email = JOptionPane.showInputDialog("Insira o email:");
                    // String cpf = JOptionPane.showInputDialog("Insira o cpf:");
                    // String nMatricula = JOptionPane.showInputDialog("Insira o n° da matrícula:");
                    alunos.add(aluno);
                    break;

                case 2:
                    professores.add(professor);
                    break;

                case 3:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Insira algo válido");
                    break;
            }
        } while (operacao != 3);
    }

    public void listarPessoa() {
        int operacao = 0;
        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog(
                        "\n" + "1. Listar Aluno \n" + "2. Listar Professor \n" + "3. Sair"));
            } catch (Exception e) {
                System.err.println(e);
                operacao = 0;
            }
        } while (operacao!=3);
    }
}
