package br.com.epicestudar;

public class Calculadora {

    public int soma(int a, int b) {
        return a + b;
    }

    public int subtracao(int a, int b) {
        return a - b;
    }

    public int multiplicacao(int a, int b) {
        return a * b;
    }

    public double divisao(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida");
        }
        return a / b;
    }

    public int raiz(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Número não pode ser negativo");
        }
        return (int) Math.sqrt(a);
    }

    public int potencia(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
