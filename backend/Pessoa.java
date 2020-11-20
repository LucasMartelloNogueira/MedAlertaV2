package backend;

//pessoa no sentido de pessoa fisica ou pessoa juridica
public abstract class Pessoa implements Contactavel, Comparable {
    private String nome; // nome da pessoa ou razao social
    private String telefone;
    private String email;

    // construtores
    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // get Nome
    @Override
    public String getNome() {
        return this.nome;
    }

    // set nome
    @Override
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // get telefone
    @Override
    public String getTelefone() {
        return this.telefone;
    }

    // set telefone
    @Override
    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    // get email
    @Override
    public String getEmail() {
        return this.email;
    }

    // set email
    @Override
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        //outraPessoa = (Pessoa) outraPessoa;
        if(this.getNome().compareTo(outraPessoa.getNome()) > 0)
            return 1;
        if(this.getNome().compareTo(outraPessoa.getNome()) < 0)
              return -1;
        return 0;
    }
}
