package backend;

import java.util.ArrayList;

public class Medicamento implements Comparable<Medicamento>{
    private String nome;
    private float preco;
    private String especificacoes;
    private String tipoDoRemedio; //comprimido? xarope?
    private String condicoesDeUso; //tomar em jejum? etc
    private boolean restricao; // precisa de receita?
    //construtores

    public Medicamento(String nome){
        this.nome = nome;
    }

    public Medicamento(String nome, float preco, String especificacoes){
        this.nome = nome;
        this.preco = preco;
        this.especificacoes = especificacoes;
    }

    public Medicamento(String nome, String tipoDoRemedio, String condicoesDeUso){
        this.nome = nome;
        this.tipoDoRemedio = tipoDoRemedio;
        this.condicoesDeUso = condicoesDeUso;
    }

    public Medicamento(String nome, String tipoDoRemedio, String condicoesDeUso, boolean restricao){
        this.nome = nome;
        this.tipoDoRemedio = tipoDoRemedio;
        this.condicoesDeUso = condicoesDeUso;
        this.restricao = restricao;
    }
    public Medicamento(String nome, float preco, String tipoDoRemedio, String condicoesDeUso, boolean restricao){
        this.nome = nome;
        this.preco = preco;
        this.tipoDoRemedio = tipoDoRemedio;
        this.condicoesDeUso = condicoesDeUso;
        this.restricao = restricao;
    }

    public Medicamento(String nome, float preco, String especificacoes, String tipoDoRemedio, String condicoesDeUso, boolean restricao){
        this.nome = nome;
        this.preco = preco;
        this.especificacoes = especificacoes;
        this.tipoDoRemedio = tipoDoRemedio;
        this.condicoesDeUso = condicoesDeUso;
        this.restricao = restricao;
    }
    //getters e setters

    public String getNome() {
        return this.nome;
    }

    public float getPreco(){
        return this.preco;
    }

    public void setPreco(float novoPreco){
        this.preco = novoPreco;
    }

    public String getEspecificacoes(){
        return this.especificacoes;
    }

    public void setEspecificacoes(String novasEspecificacoes){
        this.especificacoes = novasEspecificacoes;
    }

    public String getTipoDoRemedio() {
        return this.tipoDoRemedio;
    }

    public boolean isRestricao() {
        return this.restricao;
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

    @Override
    public String toString(){
        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        listaValoresAtributos.add(this.getNome());
        listaValoresAtributos.add(String.valueOf(this.getPreco()));

        if (this.getEspecificacoes() == null){
            listaValoresAtributos.add("null");
        }
        else{
            listaValoresAtributos.add(this.getEspecificacoes());
        }

        listaValoresAtributos.add(this.getTipoDoRemedio());
        listaValoresAtributos.add(this.getCondicoesDeUso());

        if (this.isRestricao() == false){
            listaValoresAtributos.add("false");
        }
        else{
            String valorRestricao = String.valueOf(this.isRestricao());
            listaValoresAtributos.add(valorRestricao);
        }

        String medicamentoString = String.join(",", listaValoresAtributos);
        return medicamentoString;
    }

    @Override
    public int compareTo(Medicamento o) {
        return this.getNome().compareTo(o.getNome());
    }
}
