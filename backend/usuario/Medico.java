package backend.usuario;

import backend.Pessoa;

public class Medico extends Pessoa {
    private String especialidade;

    // construtor
    public Medico(String nome, String telefone, String email, String especialidade) {
        super(nome, telefone, email);
        this.especialidade = especialidade;
    }

    // get e set
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    // get e set particularidade
    @Override
    public Object getParticularidade() {
        return getEspecialidade();
    }

    @Override
    public <T> void setParticularidade(T novaParticularidade) {
        setEspecialidade((String) novaParticularidade);
    }

    @Override
    public int compareTo(Object outraPessoa) {
        outraPessoa = (Pessoa) outraPessoa;
        if(this.getNome().compareTo(outraPessoa.getNome()) > 0)
            return 1;
        if(this.getNome().compareTo(outraPessoa.getNome()) < 0)
              return -1;
        return 0;
    }
}
