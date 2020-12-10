package backend.farmacia;

import backend.Medicamento;

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

    @Override
    public String toString(){
        String itemEstoqueString = this.getMedicamento().toString() + "," + String.valueOf(this.getQntMedicamento());
        return itemEstoqueString;
    }

    public static ItemEstoque stringToItemEstoque(String itemEstoqueString){
        String[] dadosItemEstoque = itemEstoqueString.split(",");
        String nomeMedicamento = dadosItemEstoque[0];
        Float preco = Float.parseFloat(dadosItemEstoque[1]);
        String especificacoes = dadosItemEstoque[2];
        String tipoMedicamento = dadosItemEstoque[3];
        String condicoesMedicamento = dadosItemEstoque[4];
        boolean restricaoMedicamento = Boolean.parseBoolean(dadosItemEstoque[5]);
        Medicamento medicamento = new Medicamento(nomeMedicamento,preco, especificacoes, 
                                    tipoMedicamento, condicoesMedicamento, restricaoMedicamento);
        
        int qnt = Integer.parseInt(dadosItemEstoque[6]);
        ItemEstoque itemEstoque = new ItemEstoque(medicamento, qnt);
        return itemEstoque;

    }
}
