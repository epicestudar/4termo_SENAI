package br.com.epicestudar.Model;

import java.util.*;

public class Curso {
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    public void addProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void lancarNotas(String nomeAluno, double nota) {
        for (Aluno aluno : alunos) {
            if(aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                aluno.setNota(nota);
                System.out.println("Nota inserida com sucesso");
                return;
            }
        }
        System.out.println("Aluno não encontrado");
    }

    public void resultadoFinal() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInformacoes());
            aluno.avaliarDesempenho();
        }
    }
}
