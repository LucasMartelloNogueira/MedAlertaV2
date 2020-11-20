package backend;

public interface Contactavel {
    public abstract String getNome();
    public abstract void setNome(String novoNome);
    public abstract String getTelefone();
    public abstract void setTelefone(String novoTelefone);
    public abstract String getEmail();
    public abstract void setEmail(String novoEmail);
    public abstract Object getParticularidade();  //get endereco se pessoa fisica ou juridica OU get especialidade se medico
    public abstract <T> void setParticularidade(T novaParticularidade);  //set endereco se pessoa fisica ou juridica OU set especialidade se medico
}
