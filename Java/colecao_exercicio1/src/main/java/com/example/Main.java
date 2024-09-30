package com.example;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Vendas gerenciamentoVendas = new Vendas();
        String operacao;

        do {
            operacao = JOptionPane.showInputDialog(
                "\n----Gerenciamento de Vendas----\n"
                        + "1 - Registra Venda \n"
                        + "2 - Listar Vendas do Cliente \n"
                        + "3 - Listar Vendas Valor Mínimo \n"
                        + "4 - Sair");


            switch (operacao) {
                case "1":
                    String cpfVenda = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                    String nomeProduto = JOptionPane.showInputDialog("Informe o nome do produto");
                    double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto"));
                    Produto produto = new Produto(nomeProduto, precoProduto);
                    gerenciamentoVendas.cadastroVenda(cpfVenda, produto);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", nomeProduto, 0);
                    break;

                case "2":
                String cpfCliente = JOptionPane.showInputDialog("Informe o CPF do cliente");
                System.out.println(gerenciamentoVendas.listarProdutos(cpfCliente).toString());


                case "3":
                String cpfCliente2 = JOptionPane.showInputDialog("Informe o CPF do cliente");
                double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor mínimo da lista"));

                try {
                    System.out.println(gerenciamentoVendas.listarComFiltro(cpfCliente2, valorMinimo).toString());
                } catch (Exception e) {
                    System.err.println(e);
                }


                case "4":
                System.out.println("Saindo");
            
                default:
                    break;
            }
        } while (operacao!="4");
    }
}