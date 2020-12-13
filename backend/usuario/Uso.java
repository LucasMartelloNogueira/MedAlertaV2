package backend.usuario;

import java.util.ArrayList;
import java.util.Collections;

import backend.Medicamento;

public class Uso {
    private Medicamento remedio;
    private int dose; //comprimidos, ml
    private String tipoDoRemedio; //comprimido, xarope
    private ArrayList<String> horarios = new ArrayList<>(); //a atualizar
    private ArrayList<Integer> horariosDeUso = new ArrayList<Integer>();
    private int duracaoDoTratamento; //em dias
    private int horarioDeInicio;
    private int intervalo;
    private int qtdDisponivel;

    //construtor
    public Uso(Medicamento remedio, int dose, ArrayList<String> horarios, int duracaoDoTratamento, int qtdDisponivel){
        this.remedio = remedio;
        this.dose = dose;
        this.horarios = horarios;
        this.duracaoDoTratamento = duracaoDoTratamento;
        setQtdDisponivel(qtdDisponivel);
    }

    public Uso(Medicamento remedio, int dose, ArrayList<String> horarios, int duracaoDoTratamento, int qtdDisponivel, int horarioInicial, int intervalo){
        this.remedio = remedio;
        this.dose = dose;
        this.horarios = horarios;
        this.duracaoDoTratamento = duracaoDoTratamento;
        this.horarioDeInicio = horarioInicial;
        this.intervalo = intervalo;
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

    public ArrayList<Integer> getHorariosDeUso() {
        return horariosDeUso;
    }

    public int getDuracaoDoTratamento() {
        return duracaoDoTratamento;
    }

    public int getHorarioDeInicio(){
        return this.horarioDeInicio;
    }

    public void setHorarioDeInicio(int novoHorario){
        this.horarioDeInicio = novoHorario;
    }

    public int getIntervalo(){
        return this.intervalo;
    }

    public void setIntervalo(int novoIntervalo){
        this.intervalo = novoIntervalo;
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

    public String horariosToString(){
        String horariosString = String.join("/", this.getHorarios());
        return horariosString;
    }

    public static ArrayList<String> horariosStringToList(String horariosString){
        ArrayList<String> listaHorarios = new ArrayList<>();
        
        String[] horariosArray =  horariosString.split("/");
        
        for (String horario : horariosArray){
            listaHorarios.add(horario);
        }

        return listaHorarios;
    }

    @Override
    public String toString(){
        ArrayList<String> listaValoresAtributos = new ArrayList<>();
        listaValoresAtributos.add(this.getRemedio().getNome());
        listaValoresAtributos.add(Integer.toString(this.getDose()));
        listaValoresAtributos.add(this.horariosToString());
        listaValoresAtributos.add(Integer.toString(this.getDuracaoDoTratamento()));
        listaValoresAtributos.add(Integer.toString(this.getQtdDisponivel()));
        listaValoresAtributos.add(Integer.toString(this.getHorarioDeInicio()));
        listaValoresAtributos.add(Integer.toString(this.getIntervalo()));


        String usoString = String.join(",", listaValoresAtributos);
        return usoString;
        
    }

    public static Uso stringToUso(String usoString){
        String[] dadosLinha = usoString.split(",");
        Medicamento remedio = new Medicamento(dadosLinha[0]);
        int dose = Integer.parseInt(dadosLinha[1]);
        ArrayList<String> horarios = horariosStringToList(dadosLinha[2]);
        int duracaoDoTratamento = Integer.parseInt(dadosLinha[3]);
        int qtdDisponivel = Integer.parseInt(dadosLinha[4]);
        int horarioInicial = Integer.parseInt(dadosLinha[5]);
        int intervalo = Integer.parseInt(dadosLinha[6]);

        Uso uso = new Uso(remedio, dose, horarios, duracaoDoTratamento, qtdDisponivel, horarioInicial, intervalo);
        return uso;
    }

    public void calcularHorariosDeUso() {
        int horaInicial = this.horarioDeInicio;
        
        if(intervalo==0){
            horariosDeUso.add(horaInicial);
        }
        else{
            for(int i = 0; i < 24/intervalo; i++){
                this.horariosDeUso.add(horaInicial);
                horaInicial += intervalo;
            }
        }

        Collections.sort(horariosDeUso);
    }
}
