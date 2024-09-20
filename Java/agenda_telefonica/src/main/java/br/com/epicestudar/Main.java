package br.com.epicestudar;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) throws AgendaException {
        AgendaTelefonica agenda = new AgendaTelefonica(5);
        int operador = 0;
        try {
            do {
                System.out.println("\n---Agenda Telefônica---\n");
                System.out.println("1 - Adicionar Contato");
                System.out.println("2. Listar Contatos");
                System.out.println("3. Buscar Contato (nome)");
                System.out.println("4. Remover Contato (nome)");
                System.out.println("5. Sair");
                try {
                    operador = Integer.parseInt(JOptionPane.showInputDialog("Digite a Operação"));
                } catch (NumberFormatException e) {
                    System.err.println(e);
                    operador = 0;
                }
                
    
                switch (operador) {
                    case 1:
                       try {
                        String nome = JOptionPane.showInputDialog("Digite o nome");
                        String telefone = JOptionPane.showInputDialog("Informe o telefone: ");
                        Contato contato = new Contato(nome, telefone);
                        agenda.addContato(contato);
                       } catch (Exception e) {
                        System.err.println(e);
                       }
                        break;
    
                    case 2:
                        agenda.listarContatos();
                        break;

                    case 3:
                    try {
                        String nome = JOptionPane.showInputDialog("Digite o nome");
                        System.out.println(agenda.buscarContatos(nome).toString());
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                    case 4:
                    try {
                        String nomeRemove = JOptionPane.showInputDialog("Digite o nome");
                        agenda.removerContato(nomeRemove);
                    } catch (Exception e) {
                        System.err.println(e);
                    }

    
                    default:
                    System.out.println("Digite um n° válido");
                    break;
                }
            } while (operador != 5);
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
}