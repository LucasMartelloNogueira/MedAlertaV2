package backend;

//pessoa no sentido de pessoa fisica ou pessoa juridica
public abstract class Pessoa implements Comparable<Pessoa> {
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
    public String getNome() {
        return this.nome;
    }

    // set nome
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // get telefone
    public String getTelefone() {
        return this.telefone;
    }

    // set telefone
    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    // get email
    public String getEmail() {
        return this.email;
    }

    // set email
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public abstract Object getParticularidade();  //get endereco se pessoa fisica ou juridica OU get especialidade se medico
    public abstract <T> void setParticularidade(T novaParticularidade);  //set endereco se pessoa fisica ou juridica OU set especialidade se medico

    public int compareTo(Pessoa outraPessoa) {
        /*if(this.getNome().compareTo(outraPessoa.getNome()) > 0)
            return 1;
        if(this.getNome().compareTo(outraPessoa.getNome()) < 0)
              return -1;
        return 0;*/
        return this.getNome().compareTo(outraPessoa.getNome());
    }
}
