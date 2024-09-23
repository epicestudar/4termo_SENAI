package br.com.epicestudar;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController agencia = new FuncionarioController();
        int operacao = 0;
        do {
            try {
                operacao = Integer.parseInt(JOptionPane.showInputDialog("\n " + "---Gerenciamento de Funcionário--- \n"
                        + "1.Cadastrar Funcionário \n" + "2.Listar Funcionário \n" + "3. Remover Funcionário (nome) \n"
                        + "4. Calcular Média Salarial \n" + "5. Sair \n"));
            } catch (Exception e) {
                System.err.println(e);
                operacao = 0;
            }

            switch (operacao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Digite o nome:");
                    int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
                    double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario"));
                    agencia.addFuncionario(new Funcionario(nome, idade, salario));
                    break;
                case 2:
                    agencia.listarFuncionarios();
                    break;
                case 3:
                    String nomef = JOptionPane.showInputDialog("Digite o nome:");
                    try {
                        agencia.removerFuncionario(nomef);
                    } catch (Exception e) {
                        System.err.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Média Salarial: " + agencia.mediaSalarial());
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }
        } while (operacao != 5);
    }
}
