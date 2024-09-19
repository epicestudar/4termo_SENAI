package br.com.epicestudar;

import java.util.Scanner;

public class Exercicio1 {
    double[] notas = new double[4];
    double mediaNotas = 0;
    boolean bonus = true;

    Scanner sc = new Scanner(System.in);

    public void calculoNotas() {
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a nota " + (i+1) + ":");
            notas[i] = sc.nextDouble();
            mediaNotas += notas[i];

            if(notas[i] < 9) {
                bonus = false;
            }
        }
        mediaNotas/=notas.length;

        if(bonus) {
            mediaNotas = (mediaNotas*1.1>10?mediaNotas=10:mediaNotas*1.1);
            System.out.println("Parabéns, sua média foi: " + mediaNotas);
        }

        if(mediaNotas >= 7) {
            System.out.println("Parabéns! Você foi aprovado. Sua média final foi: " + mediaNotas);
        }
        else if(mediaNotas >= 5 && mediaNotas<= 6.9) {
            System.out.println("Você ficou de recuperação. Sua média final foi: " + mediaNotas);
        } else if(mediaNotas < 5) {
            System.out.println("Você foi reprovado. Sua média final foi: " + mediaNotas);
        }
    }
}
