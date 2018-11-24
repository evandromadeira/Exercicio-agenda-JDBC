package agenda.controle;

import agenda.exception.AgendaException;
import agenda.modelo.Pessoa;
import java.util.ArrayList;

public class AgendaContatos {

    private ArrayList<Pessoa> contatos;

    //1. deve ser utilizado este atributo DAO para realizar o acesso ao banco de dados
    //2. Não deve ser aberto nesta classe uma conexão direta com o banco de dados
    private AgendaContatosDao dao = new AgendaContatosDao();

    public AgendaContatos() throws AgendaException {
        //utilizar o método dao.getAll() para retornar todas as pessoas do banco de dados
        contatos = dao.getAll();
    }

    public ArrayList<Pessoa> getContatos() {
        return contatos;
    }

    public int qtdadeContatos() {
        return contatos.size();
    }

    public void adicionar(Pessoa contato) throws AgendaException {
        if (contato.getNome().trim() == null) {
            throw new AgendaException("A inclusao do nome e obrigatoria. ");
        }
        if (contato.getTelefone().trim() == null) {
            throw new AgendaException("A inclusao do telefone e obrigatoria. ");
        }

        if (dao.exists(contato)) {
            dao.update(contato);
            atualizaContato(contato);
        } else {
            dao.insert(contato);
            contatos.add(contato);
        }
    }

    public void remover(int posicao) throws AgendaException {
        // Verifica se posicao e valida
        if ((posicao >= 0) && (posicao < contatos.size())) {
            // Remove contato
            dao.delete(contatos.get(posicao));
            contatos.remove(posicao);

            //deve ser executado o comando DELETE no banco de dados
        } else {
            throw new AgendaException("Posicao ( " + posicao + " ) invalida.");
        }
    }

    public void atualizaContato(Pessoa contato) {
        for (Pessoa p : contatos) {
            if (contato.getNome().trim().equals(p.getNome().trim())) {
                p.setEndereco(contato.getEndereco());
                p.setTelefone(contato.getTelefone());
                break;
            }
        }
    }
}
