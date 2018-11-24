package agenda.modelo;

/**
 * A classe Pessoa representa uma pessoa, mantendo informacaes sobre o nome completo,
 *   endereco e telefone de contato.
 *
 */
public class Pessoa {

    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa() {
    }

    /**
     * Cria uma nova pessoa com as informacoes recebidas como parametro.
     *
     * @param nomePessoa Nome completo da pessoa
     * @param enderecoPessoa Endereco completo da pessoa
     * @param telefonePessoa Telefone de contato da pessoa
     */
    public Pessoa(String nomePessoa, String enderecoPessoa, String telefonePessoa) {
        nome = nomePessoa;
        endereco = enderecoPessoa;
        telefone = telefonePessoa;
    }

    /**
     * Recupera o nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Recupera o endereco da pessoa.
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Recupera o telefone de contato da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define / modifica o nome da pessoa.
     *
     * @param novoNome Nome completo da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define / modifica o endereco da pessoa.
     *
     * @param novoEndereco Endereco completo da pessoa
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Define / modifica o telefone de contato da pessoa.
     *
     * @param novoTelefone Telefone de contato  da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Recupera uma versao textual dos dados mantidos pelo objeto.
     */
    public String toString() {
        return "(" + this.nome + ", " + this.endereco + ", " + this.telefone + ")";
    }
}