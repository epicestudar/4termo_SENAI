import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner scanner = new Scanner(System.in);
        int escolha;


        do {
            // Exibindo o menu de navegação
            System.out.println("\nAgenda Telefônica:");
            System.out.println("1. Adicionar novo contato");
            System.out.println("2. Exibir contatos em ordem");
            System.out.println("3. Exibir contatos em pré-ordem");
            System.out.println("4. Exibir contatos em pós-ordem");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha


            // Executando a ação com base na escolha do usuário
            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    agenda.exibirContatos();
                    break;
                case 3:
                    agenda.exibirPreOrder();
                    break;
                case 4:
                    agenda.exibirPostOrder();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (escolha != 5);


        scanner.close();
    }

    }