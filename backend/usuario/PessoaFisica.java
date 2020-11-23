package backend.usuario;

import backend.Agenda;
import backend.Endereco;
import backend.Pessoa;

public class PessoaFisica extends Pessoa {
    private Endereco endereco;
    private Agenda contatosMedicos = new Agenda();
    private Agenda constatosFarmacias = new Agenda();
    //lista de usos

    public PessoaFisica(String nome, String telefone, String email, Endereco endereco) {
        super(nome, telefone, email);
        this.endereco = endereco;
    }

    //get e set
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
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
