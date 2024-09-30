package br.com.epicestudar;

import javax.swing.JOptionPane;

import br.com.epicestudar.Controller.PessoaController;
import br.com.epicestudar.Model.Aluno;
import br.com.epicestudar.Model.Professor;

public class Main {
    public static void main(String[] args) {
        PessoaController gerenciamento = new PessoaController();
        int operacao = 0;
        try {
            do {
                operacao = Integer.parseInt(
                        JOptionPane.showInputDialog("--- Gerenciamento de Cursos --- \n" + "1. Cadastro de Pessoa \n"
                                + "2. Listar Pessoas \n" + "3. Remover Pessoas \n" + "4. Sair \n"));

                switch (operacao) {
                    case 1:

                        int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                                "\n" + "1. Cadastrar Aluno \n" + "2. Cadastrar Professor \n" + "3. Sair"));
                        switch (opcao) {
                            case 1:
                                String nomeAluno = JOptionPane.showInputDialog("Informe o nome do Aluno");
                                String emailAluno = JOptionPane.showInputDialog("Informe o email do Aluno");
                                String cpfAluno = JOptionPane.showInputDialog("Informe o CPF do Aluno");
                                String nMatricula = JOptionPane.showInputDialog("Informe o número da matrícula");
                                double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota"));
                                gerenciamento.addAluno(new Aluno(nomeAluno, emailAluno, cpfAluno, nMatricula, nota));
                                break;

                            case 2:
                                String nomeProfessor = JOptionPane.showInputDialog("Informe o nome do Aluno");
                                String emailProfessor = JOptionPane.showInputDialog("Informe o email do Aluno");
                                String cpfProfessor = JOptionPane.showInputDialog("Informe o CPF do Aluno");
                                double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario:"));
                                gerenciamento.addProfessor(
                                        new Professor(nomeProfessor, emailProfessor, cpfProfessor, salario));
                                break;

                            case 3:
                                System.out.println("Saindo");

                            default:
                                break;
                        }
                        break;

                    case 2:
                        gerenciamento.listarPessoa();

                    case 3:
                        int escolha = Integer.parseInt(JOptionPane.showInputDialog(
                                "\n" + "1. Remover Aluno \n" + "2. Remover Professor \n" + "3. Sair"));

                        switch (escolha) {
                            case 1:
                                String nomeAluno = JOptionPane.showInputDialog("Digite o nome:");
                                gerenciamento.removerAluno(nomeAluno);

                                break;

                            case 2:
                                String nomeProfessor = JOptionPane.showInputDialog("Digite o nome: ");
                                gerenciamento.removerProfessor(nomeProfessor);
                                break;

                            default:
                                break;
                        }


                    case 4:
                    System.out.println("Saindo...");
                    break;


                    default:
                        break;
                }
            } while (operacao != 4);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}