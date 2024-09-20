package br.com.epicestudar;

public class AgendaTelefonica {
    private Contato[] contatos;
    private int cont;

    public AgendaTelefonica(int maxContato) {
        contatos = new Contato[maxContato];
        cont = 0;
    }

    public void addContato(Contato contato) throws AgendaException{
        if(cont>=contatos.length) {
            throw new AgendaException("Agenda cheia");
        }
        contatos[cont] = contato;
        cont++;
        System.out.println("Contato adicionado com suesso");
    }

    public void listarContatos() {
        if(cont == 0) {
            System.out.println("Agenda vazia");
        } else{
            for (int i = 0; i < cont; i++) {
                System.out.println(contatos[i].toString());
            }
        }
    }

    public Contato buscarContatos(String nome) throws BuscarException{
        for (int i = 0; i < cont; i++) {
            if(contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new BuscarException("Contato não encontrado");
    }

    public void removerContato(String nome) throws BuscarException{
        boolean encontrado = false;
        for (int i = 0; i < cont; i++) {
            if(contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i] = contatos[cont - 1];
                contatos[cont - 1] = null;
                cont--;
                System.out.println("Contato removido com sucesso");
            }
        }
        if(!encontrado) {
            throw new BuscarException("Contato não encontrado");
        }
    }
}
