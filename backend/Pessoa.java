package backend;

public class Pessoa {
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // get Nome
    public String getNome(){
        return this.nome;
    }

    // set nome
    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    // get telefone
    public String getTelefone(){
        return this.telefone;
    }

    // set telefone
    public void setTelefone(String novoTelefone){
        this.telefone = novoTelefone;
    }

    // get email
    public String getEmail(){
        return this.email;
    }

    // set email
    public void setEmail(String novoEmail){
        this.email = novoEmail;
    }

}
