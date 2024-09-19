package br.com.epicestudar;

import java.util.Scanner;

public class Exercicio3 {
    double a;
    double b;
    double resultado;
    int escolha; // escolha da operação

    Scanner sc = new Scanner(System.in);

    // criar os métodos das operações

    public double somar(double a, double b) {
        resultado = a + b;
        return resultado;
    }

    public double subtrair(double a, double b) {
        resultado = a - b;
        return resultado;
    }

    public double multiplicar(double a, double b) {
        resultado = a * b;
        return resultado;
    }

    public double divisao(double a, double b) {
        try {
            resultado = a / b;
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultado;
    }

    public double raiz(double a) throws Exception {
        if (a < 0) {
            throw new Exception("Informe um número válido");
        }
        try {
            resultado = Math.sqrt(a);
        } catch (Exception e) {
            System.err.println(e);
        }
        return resultado;
    }

    public void menu() {
        System.out.println("Calculadora");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Sair");
    }

    public void entradaDados() {
        if (escolha >= 1 && escolha < 5) {
            System.out.println("Digite o valor a:");
            a = sc.nextDouble();
            System.out.println("Digite o valor b");
            b = sc.nextDouble();
        } else if (escolha == 5) {
            System.out.println("Digite o valor a");
            a = sc.nextDouble();
        } else if (escolha == 6) {
            System.out.println("Saindo...");
        }
    }

    public void calculadora() {
        do {
            menu();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        entradaDados();
                        somar(a, b);
                        break;
                    case 2:
                        entradaDados();
                        subtrair(a, b);
                        break;

                    case 3:
                        entradaDados();
                        multiplicar(a, b);
                        break;

                    case 4:
                        entradaDados();
                        divisao(a, b);
                        break;

                    case 5:
                        entradaDados();
                        raiz(a);
                        break;

                    case 6:
                        entradaDados();
                        break;

                    default:
                        entradaDados();
                        break;
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        } while (escolha != 6);
    }
}
