package br.com.epicestudar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Exercicios {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Mova a URL para um nível de classe
    private static final String USER = "postgres"; // Substitua com seu usuário do PostgreSQL
    private static final String PASSWORD = "postgres"; // Substitua com sua senha do PostgreSQL

    public void exercicio1() {
        String arquivo = "notas.txt";
        String nomeMaiorMedia = "";
        String nomeMenorMedia = "";
        double maiorMedia = Double.MIN_VALUE;
        double menorMedia = Double.MAX_VALUE;
        double somaMedias = 0;
        int totalAlunos = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                String nome = dados[0];
                double somaNotas = 0;
                int quantidadeNotas = dados.length - 1;

                for (int i = 1; i <= quantidadeNotas; i++) {
                    somaNotas += Double.parseDouble(dados[i]);
                }

                double media = somaNotas / quantidadeNotas;

                if (media > maiorMedia) {
                    maiorMedia = media;
                    nomeMaiorMedia = nome;
                }

                if (media < menorMedia) {
                    menorMedia = media;
                    nomeMenorMedia = nome;
                }

                somaMedias += media;
                totalAlunos++;
            }

            double mediaGeral = somaMedias / totalAlunos;

            System.out.println("Aluno com a maior média: " + nomeMaiorMedia + " (Média: " + maiorMedia + ")");
            System.out.println("Aluno com a menor média: " + nomeMenorMedia + " (Média: " + menorMedia + ")");
            System.out.println("Média geral da turma: " + mediaGeral);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public void exercicio2() {
        try {
            // Conectar à API
            URL url = new URL("http://localhost:3000/users");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            // Processar o JSON recebido
            JSONArray users = new JSONArray(content.toString());

            int totalUsuarios = users.length();
            int somaIdades = 0;

            System.out.println("Usuários:");
            for (int i = 0; i < users.length(); i++) {
                JSONObject user = users.getJSONObject(i);
                String nome = user.getString("name");
                int idade = user.getInt("age");
                String cidade = user.getString("city");

                somaIdades += idade;

                System.out.println("Nome: " + nome + ", Idade: " + idade + ", Cidade: " + cidade);
            }

            double mediaIdade = (double) somaIdades / totalUsuarios;

            // Exibir resultados
            System.out.println("\nNúmero total de usuários: " + totalUsuarios);
            System.out.println("Média de idade dos usuários: " + mediaIdade);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exercicio3() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres"; // substitua com seu usuário do PostgreSQL
        String password = "postgres"; // substitua com sua senha do PostgreSQL

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement()) {

            String query = "SELECT nome, preco FROM produtos";
            ResultSet rs = stmt.executeQuery(query);

            String nomeMaisCaro = "";
            String nomeMaisBarato = "";
            double precoMaisCaro = Double.MIN_VALUE;
            double precoMaisBarato = Double.MAX_VALUE;
            double somaPrecos = 0;
            int totalProdutos = 0;

            System.out.println("Lista de Produtos:");
            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                System.out.println("Nome: " + nome + ", Preço: " + preco);

                if (preco > precoMaisCaro) {
                    precoMaisCaro = preco;
                    nomeMaisCaro = nome;
                }

                if (preco < precoMaisBarato) {
                    precoMaisBarato = preco;
                    nomeMaisBarato = nome;
                }

                somaPrecos += preco;
                totalProdutos++;
            }

            double mediaPrecos = somaPrecos / totalProdutos;

            System.out.println("\nProduto mais caro: " + nomeMaisCaro + " (Preço: " + precoMaisCaro + ")");
            System.out.println("Produto mais barato: " + nomeMaisBarato + " (Preço: " + precoMaisBarato + ")");
            System.out.println("Média de preços: " + mediaPrecos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exercicio4() {
        String inputFile = "produtos.csv";
        String outputFile = "produtos_com_valor_estoque.csv";

        String linhaComMaiorValorEstoque = "";
        double maiorValorEstoque = Double.MIN_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String linha = br.readLine(); // Lê o cabeçalho
            if (linha != null) {
                bw.write(linha + ",valor_total_estoque\n"); // Escreve o cabeçalho no arquivo de saída
            }

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                String nome = campos[0];
                int quantidade = Integer.parseInt(campos[1]);
                double preco = Double.parseDouble(campos[2]);

                double valorTotalEstoque = quantidade * preco;

                // Verifica se é o maior valor total de estoque encontrado
                if (valorTotalEstoque > maiorValorEstoque) {
                    maiorValorEstoque = valorTotalEstoque;
                    linhaComMaiorValorEstoque = linha + "," + valorTotalEstoque;
                }

                // Escreve a linha original com o valor total do estoque no novo arquivo
                bw.write(nome + "," + quantidade + "," + preco + "," + valorTotalEstoque + "\n");
            }

            System.out.println("Produto com o maior valor total em estoque:");
            System.out.println(linhaComMaiorValorEstoque);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exercicio5() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            boolean continuar = true;

            while (continuar) {
                System.out.println("Selecione uma opção:");
                System.out.println("1. Exibir todos os clientes");
                System.out.println("2. Adicionar um novo cliente");
                System.out.println("3. Atualizar o e-mail de um cliente pelo ID");
                System.out.println("4. Excluir um cliente pelo ID");
                System.out.println("5. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        exibirClientes(con);
                        break;

                    case 2:
                        System.out.print("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o e-mail do cliente: ");
                        String email = scanner.nextLine();
                        adicionarCliente(con, nome, email);
                        break;

                    case 3:
                        System.out.print("Digite o ID do cliente: ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        System.out.print("Digite o novo e-mail do cliente: ");
                        String novoEmail = scanner.nextLine();
                        atualizarEmailCliente(con, idAtualizar, novoEmail);
                        break;

                    case 4:
                        System.out.print("Digite o ID do cliente: ");
                        int idExcluir = scanner.nextInt();
                        excluirCliente(con, idExcluir);
                        break;

                    case 5:
                        continuar = false;
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exibirClientes(Connection con) throws Exception {
        String query = "SELECT id, nome, email FROM clientes";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Lista de Clientes:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Nome: " + nome + ", E-mail: " + email);
            }
            System.out.println();
        }
    }

    private static void adicionarCliente(Connection con, String nome, String email) throws Exception {
        String query = "INSERT INTO clientes (nome, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Cliente adicionado: " + nome + " (" + email + ")\n");
        }
    }

    private static void atualizarEmailCliente(Connection con, int id, String novoEmail) throws Exception {
        String query = "UPDATE clientes SET email = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, novoEmail);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("E-mail atualizado para o cliente com ID " + id + "\n");
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.\n");
            }
        }
    }

    private static void excluirCliente(Connection con, int id) throws Exception {
        String query = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente com ID " + id + " excluído.\n");
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.\n");
            }
        }
    }
}