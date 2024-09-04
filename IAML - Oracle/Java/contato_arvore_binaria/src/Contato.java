public class Contato {
    String nome;
    String telefone;
    Contato esquerda;
    Contato direita;

    Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.esquerda = null;
        this.direita = null;
    }
}
