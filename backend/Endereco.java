package backend;

public class Endereco {
    private String nomeDaRua;
    private String numero;
    private String complemento;
    private String nomeDoBairro;
    private String nomeDaCidade;
    private String nomeDoEstado;
    private String nomeDoPais;
    private String cep;

    // construtores

    public Endereco(String nomeDaRua, String numero){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
    }

    public Endereco(String nomeDaRua, String numero, String complemento){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(String nomeDaRua, String numero, String complemento, String cep){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco(String nomeDaRua, String numero, String complemento, String nomeDoBairro, 
                    String nomeDaCidade, String nomeDoEstado, String nomeDoPais, String cep){
        
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
        this.nomeDoBairro = nomeDoBairro;
        this.nomeDaCidade = nomeDaCidade;
        this.nomeDoEstado = nomeDoEstado;
        this.nomeDoPais = nomeDoPais;
        this.cep = cep;
    }

    // getters e setters

    public String getNomeDaRua(){
        return this.nomeDaRua;
    }

    public void setNomeDaRua(String novoNomeRua){
        this.nomeDaRua = novoNomeRua;
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String novoNumero){
        this.numero = novoNumero;
    }

    public String getComplemento(){
        return this.complemento;
    }

    public void setComplemento(String novoComplemento){
        this.complemento = novoComplemento;
    }

    public String getNomeDoBairro(){
        return this.nomeDoBairro;
    }

    public void setNomeDoBairro(String novoNomeDoBairro){
        this.nomeDoBairro = novoNomeDoBairro;
    }

    public String getNomeDaCidade(){
        return this.nomeDaCidade;
    }

    public void setNomeDaCidade(String novoNomeDaCidade){
        this.nomeDaCidade = novoNomeDaCidade;
    }

    public String getNomeDoEstado(){
        return this.nomeDoEstado;
    }

    public void setNomeDoEstado(String novoNomeDoEstado){
        this.nomeDoEstado = novoNomeDoEstado;
    }

    public String getNomeDoPais(){
        return this.nomeDoPais;
    }

    public void setNomeDoPais(String novoNomeDoPais){
        this.nomeDoPais = novoNomeDoPais;
    }

    public String getCep(){
        return this.cep;
    }

    public void setCep(String novoCep){
        this.cep = novoCep;
    }

}
