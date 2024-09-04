import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         BinaryTreeNavigation tree = new BinaryTreeNavigation();


        // Construindo uma árvore binária simples que representa um diretório de
        // arquivos
        Node root = new Node("C:");
        root.left = new Node("Program Files");
        root.right = new Node("Users");
        root.left.left = new Node("Java");
        root.left.right = new Node("Python");
        root.right.left = new Node("Admin");
        root.right.right = new Node("Guest");


        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            // Exibindo o menu de navegação
            System.out.println("\nSistema de Navegação de Diretórios:");
            System.out.println("1. Travessia em Pré-Ordem");
            System.out.println("2. Travessia em Pós-Ordem");
            System.out.println("3. Travessia em Ordem (In-Order)");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();


            // Executando a ação com base na escolha do usuário
            switch (choice) {
                case 1:
                    System.out.println("Travessia em Pré-Ordem:");
                    tree.preOrderTraversal(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Travessia em Pós-Ordem:");
                    tree.postOrderTraversal(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Travessia em Ordem (In-Order):");
                    tree.inOrderTraversal(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 4);


        scanner.close();
    }

    }
