package backend.usuario;

import java.util.ArrayList;

import backend.Medicamento;

public class Uso {
    private Medicamento remedio;
    private int dose;
    private ArrayList<String> horarios = new ArrayList<>(); //a atualizar
    private int duracaoDoTratamento;
    private int qtdDisponivel;

    //construtor
    public Uso(Medicamento remedio, int dose, ArrayList<String> horarios, int duracaoDoTratamento, int qtdDisponivel){
        this.remedio = remedio;
        this.dose = dose;
        this.horarios = horarios;
        this.duracaoDoTratamento = duracaoDoTratamento;
        setQtdDisponivel(qtdDisponivel);
    }

    public int getDose() {
        return dose;
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

    public void setDose(int dose) throws IllegalArgumentException{
        if(dose<0){
            throw new IllegalArgumentException("Não é possível setar numero negativo para dose.");
        }
        this.dose = dose;
    }

    public void setDuracaoDoTratamento(int duracaoDoTratamento) throws IllegalArgumentException{
        if(duracaoDoTratamento<0){
            throw new IllegalArgumentException("Não é possível setar numero negativo para duração do Tratamento.");
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
