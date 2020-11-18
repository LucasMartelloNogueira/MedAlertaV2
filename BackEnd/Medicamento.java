package BackEnd;

public class Medicamento {
    private String nome;
    private String tipoDoRemedio; //comprimido? xarope?
    private boolean restricao; // precisa de receita?
    private String condicoesDeUso; //tomar em jejum? etc

    //construtores
    public Medicamento(String nome, String tipoDoRemedio, String condicoesDeUso){
        this.nome = nome;
        this.tipoDoRemedio = tipoDoRemedio;
        this.condicoesDeUso = condicoesDeUso;
    }

    public Medicamento(String nome, String tipoDoRemedio, boolean restricao, String condicoesDeUso){
        this.nome = nome;
        this.tipoDoRemedio = tipoDoRemedio;
        this.restricao = restricao;
        this.condicoesDeUso = condicoesDeUso;
    }


    //getters e setters

    public String getNome() {
        return nome;
    }

    public String getTipoDoRemedio() {
        return tipoDoRemedio;
    }

    public boolean isRestricao() {
        return restricao;
    }

    public String getCondicoesDeUso() {
        return condicoesDeUso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTipoDoRemedio(String tipoDoRemedio) {
        this.tipoDoRemedio = tipoDoRemedio;
    }

    public void setCondicoesDeUso(String condicoesDeUso) {
        this.condicoesDeUso = condicoesDeUso;
    }

    public void setRestricao(boolean restricao) {
        this.restricao = restricao;
    }
}
