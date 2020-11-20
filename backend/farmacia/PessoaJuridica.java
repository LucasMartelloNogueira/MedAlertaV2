package backend.farmacia;

import backend.Pessoa;
import backend.Agenda;
import backend.Endereco;

public class PessoaJuridica extends Pessoa{
    private Endereco endereco;
    private Estoque estoque;
    private Agenda contatosClientes;
    private String cnpj;


    public PessoaJuridica(String nome, String telefone, String email){
        super(nome, telefone, email);
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    //get e set particularidade 
    @Override
    public Object getParticularidade() {
        return getEndereco();
    }

    @Override
    public <T> void setParticularidade(T novaParticularidade) {
        setEndereco((Endereco)novaParticularidade);
    }
}
