package br.com.epicestudar;

import java.util.Scanner;

public class Exercicio4 {
    int a = -1;
    int resultado;

    Scanner sc = new Scanner(System.in);

    public long calcularFatorial(int a) throws Exception {
       if(a == 0 || a == 1) {
        return 1;
       } else {
        return a*calcularFatorial(a - 1);
       }
    }
    public void calculadora() throws Exception{
        System.out.println("Digite um n° para calcular o fatorial");
         a = sc.nextInt();
         if(a<0) {
            throw new Exception("O n° deve ser positivo");
         }
         try {
            System.out.println(calcularFatorial(a));
         } catch (Exception e) {
            System.err.println(e);
         }
    }
}
