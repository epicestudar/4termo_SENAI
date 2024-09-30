package br.com.epicestudar;

import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);
    public void exercicio1() {
        double[] notas = new double[4];
        double soma = 0;
        boolean todasNotasAcimaDeNove = true;

        // Captura as notas das 4 disciplinas
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota da disciplina " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            soma += notas[i];

            // Verifica se a nota é menor que 9
            if (notas[i] <= 9) {
                todasNotasAcimaDeNove = false;
            }
        }

        // Calcula a média
        double media = soma / 4;

        // Aplica o bônus de 10% se todas as notas forem maiores que 9
        if (todasNotasAcimaDeNove) {
            media += media * 0.10;
        }

        // Exibe o status do aluno
        System.out.println("Média final: " + media);
        if (media >= 7) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5 && media < 7) {
            System.out.println("Status: Recuperação");
        } else {
            System.out.println("Status: Reprovado");
        }

        sc.close();
    }
}
