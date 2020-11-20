package backend;

public class ItemEstoque {
    private Medicamento medicamento;
    private int qntMedicamento;

    public ItemEstoque(Medicamento medicamento, int qntMedicamento){
        this.medicamento = medicamento;
        this.qntMedicamento = qntMedicamento;
    }

    // getters e setters

    public Medicamento getMedicamento(){
        return this.medicamento;
    }

    // nao faze sentido crir um metodo "setMedicamento"
    // pq caso fosse mudar o medicamento, basta adicionar outro objeto
    // da classe ItemEstoque (com outro medicamento diferente)
    // na classe Estoque
    
    public int getQntMedicamento(){
        return this.qntMedicamento;
    }

    public void setQntMedicamento(int novaQntMedicamento){
        this.qntMedicamento = novaQntMedicamento;
    }
}
