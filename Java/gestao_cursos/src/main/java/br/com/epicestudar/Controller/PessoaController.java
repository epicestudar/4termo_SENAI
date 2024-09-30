package br.com.epicestudar.Controller;

import java.util.*;

import br.com.epicestudar.Model.Aluno;
import br.com.epicestudar.Model.Professor;
import javax.swing.JOptionPane;

public class PessoaController {
    private List<Aluno> alunos;
    private List<Professor> professores;

    public PessoaController() {
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public void listarPessoa() {
        int operacao = 0;
        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog(
                        "\n" + "1. Listar Alunos \n" + "2. Listar Professores \n" + "3. Sair"));

                switch (operacao) {
                    case 1:
                        if (alunos.size() == 0) {
                            System.out.println("Lista Vazia");
                        } else {
                            for (Aluno aluno : alunos) {
                                System.out.println(aluno.exibirInformacoes());
                            }
                        }

                        break;

                    case 2:
                        if (professores.size() == 0) {
                            System.out.println("Lista Vazia");
                        } else {
                            for (Professor professor : professores) {
                                System.out.println(professor.exibirInformacoes());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saindo");
                        break;

                    default:
                        System.out.println("Insira algo válido");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e);
                operacao = 0;
            }
        } while (operacao != 3);
    }

    public void removerAluno(String nome) {
        try {
            boolean encontrado = false;
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                alunos.remove(aluno);
                encontrado = true;
            }
        }
        if(!encontrado) {
            throw new Exception("Aluno não encontrado");
        }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void removerProfessor(String nome) {
        try {
            boolean encontrado = false;
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                professores.remove(professor);
                encontrado = true;
            }
        }
        if(!encontrado) {
            throw new Exception("Professor não encontrado");
        }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
