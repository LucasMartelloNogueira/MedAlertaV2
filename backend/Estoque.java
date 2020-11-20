package backend;

import java.util.ArrayList;

public class Estoque {
    public ArrayList<ItemEstoque> listaEstoque;

    public Estoque(){
        this.listaEstoque = new ArrayList<ItemEstoque>();
    }

    public void addMedicamentoEstoque(Medicamento medicamento, int qntMedicamento){
        ItemEstoque novoEstoqueRemedio = new ItemEstoque(medicamento, qntMedicamento);
        this.listaEstoque.add(novoEstoqueRemedio);
    }

    public void removerMedicamentoEstoque(ItemEstoque itemEstoque){
        this.listaEstoque.remove(itemEstoque);
    }

    
}
