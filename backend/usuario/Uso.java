package backend.usuario;

import java.util.ArrayList;
import backend.Medicamento;

public class Uso {
    private Medicamento remedio;
    private int dose; //comprimidos, ml
    private String tipoDoRemedio; //comprimido, xarope
    private ArrayList<String> horarios = new ArrayList<>(); //a atualizar
    private int duracaoDoTratamento; //em dias
    private String horarioDeInicio;
    private float intervalo;
    private int qtdDisponivel;

    //construtor
    public Uso(Medicamento remedio, int dose, ArrayList<String> horarios, int duracaoDoTratamento, int qtdDisponivel){
        this.remedio = remedio;
        this.dose = dose;
        this.horarios = horarios;
        this.duracaoDoTratamento = duracaoDoTratamento;
        setQtdDisponivel(qtdDisponivel);
    }

    //getters e setters
    public Medicamento getRemedio() {
        return remedio;
    }

    public int getDose() {
        return dose;
    }

    public String getTipoDoRemedio() {
        return tipoDoRemedio;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public int getDuracaoDoTratamento() {
        return duracaoDoTratamento;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setRemedio(Medicamento remedio) {
        this.remedio = remedio;
    }

    public void setDose(int dose) throws IllegalArgumentException{
        if(dose<0){
            throw new IllegalArgumentException("Não é possível setar número negativo para dose.");
        }
        this.dose = dose;
    }

    public void setTipoDoRemedio(String tipoDoRemedio) throws IllegalArgumentException{
        if(tipoDoRemedio == ""){
            throw new IllegalArgumentException("É necessário informar tipo do remédio.");
        }
        this.tipoDoRemedio = tipoDoRemedio;
    }

    public void setDuracaoDoTratamento(int duracaoDoTratamento) throws IllegalArgumentException{
        if(duracaoDoTratamento<0){
            throw new IllegalArgumentException("Não é possível setar número negativo para duração do Tratamento.");
        }
        this.duracaoDoTratamento = duracaoDoTratamento;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios; //a atualizar
    }

    public void setQtdDisponivel(int qtdDisponivel) throws IllegalArgumentException{
        if(qtdDisponivel<0){
            throw new IllegalArgumentException("Não é possível setar quantidade negativa de um medicamento.");
        }
        this.qtdDisponivel = qtdDisponivel;
    }
}
