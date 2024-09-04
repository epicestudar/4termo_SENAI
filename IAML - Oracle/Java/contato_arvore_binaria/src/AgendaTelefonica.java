public class AgendaTelefonica {
    private Contato raiz; // Raiz da árvore binária


    // Método para adicionar um novo contato na árvore binária
    public void adicionarContato(String nome, String telefone) {
        raiz = adicionarRecursivo(raiz, nome, telefone);
        System.out.println("Contato adicionado com sucesso!");
    }


    // Método recursivo para inserir um novo nó na árvore binária
    private Contato adicionarRecursivo(Contato atual, String nome, String telefone) {
        if (atual == null) {
            return new Contato(nome, telefone);
        }


        if (nome.compareTo(atual.nome) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, nome, telefone);
        } else if (nome.compareTo(atual.nome) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, nome, telefone);
        } else {
            // Nomes duplicados não são permitidos
            System.out.println("Contato com este nome já existe!");
        }


        return atual;
    }


    // Método para exibir os contatos em ordem (in-order traversal)
    public void exibirContatos() {
        if (raiz == null) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            System.out.println("Lista de Contatos (em ordem alfabética):");
            exibirInOrder(raiz);
        }
    }


    // Método recursivo para a travessia in-order
    private void exibirInOrder(Contato atual) {
        if (atual != null) {
            exibirInOrder(atual.esquerda);
            System.out.println("Nome: " + atual.nome + ", Telefone: " + atual.telefone);
            exibirInOrder(atual.direita);
        }
    }


    // Método de travessia pré-ordem (pre-order traversal)
    public void exibirPreOrder() {
        System.out.println("Contatos em Pré-Ordem:");
        exibirPreOrderRecursivo(raiz);
    }


    private void exibirPreOrderRecursivo(Contato atual) {
        if (atual != null) {
            System.out.println("Nome: " + atual.nome + ", Telefone: " + atual.telefone);
            exibirPreOrderRecursivo(atual.esquerda);
            exibirPreOrderRecursivo(atual.direita);
        }
    }


    // Método de travessia pós-ordem (post-order traversal)
    public void exibirPostOrder() {
        System.out.println("Contatos em Pós-Ordem:");
        exibirPostOrderRecursivo(raiz);
    }


    private void exibirPostOrderRecursivo(Contato atual) {
        if (atual != null) {
            exibirPostOrderRecursivo(atual.esquerda);
            exibirPostOrderRecursivo(atual.direita);
            System.out.println("Nome: " + atual.nome + ", Telefone: " + atual.telefone);
        }


    }

}
