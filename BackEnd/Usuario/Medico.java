package backend.usuario;

import backend.Endereco;
import backend.Pessoa;

public class Medico extends Pessoa {
    private String especialidade;
    private Endereco enderecoDaClinica;

    //construtores
    public Medico(String nome, String telefone, String email) {
        super(nome, telefone, email);
    }

    public Medico(String nome, String telefone, String email, String especialidade, Endereco enderecoDaClinica) {
        super(nome, telefone, email);
        this.especialidade = especialidade;
        this.enderecoDaClinica = enderecoDaClinica;
    }

    //getters e setters
    public String getEspecialidade() {
        return especialidade;
    }

    public Endereco getEnderecoDaClinica() {
        return enderecoDaClinica;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setEnderecoDaClinica(Endereco enderecoDaClinica) {
        this.enderecoDaClinica = enderecoDaClinica;
    }
}
