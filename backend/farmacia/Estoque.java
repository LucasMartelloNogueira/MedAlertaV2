package backend.farmacia;

import java.util.ArrayList;
import backend.Medicamento;

public class Estoque {
    public ArrayList<ItemEstoque> listaEstoque;

    public Estoque(){
        this.listaEstoque = new ArrayList<ItemEstoque>();
    }

    public void addMedicamentoEstoque(Medicamento medicamento, int qntMedicamento){
        ItemEstoque novoEstoqueRemedio = new ItemEstoque(medicamento, qntMedicamento);
        this.listaEstoque.add(novoEstoqueRemedio);
    }

    public void addMedicamentoEstoque(ItemEstoque itemEstoque){
        this.listaEstoque.add(itemEstoque);
    }

    public void removerMedicamentoEstoque(ItemEstoque itemEstoque){
        this.listaEstoque.remove(itemEstoque);
    }

    public void atualizarQntMedicamento(Medicamento medicamento, int novaQuantidade){
        for (ItemEstoque itemEstoque : this.listaEstoque){
            if (itemEstoque.getMedicamento().getNome().equals(medicamento.getNome())){
                itemEstoque.setQntMedicamento(novaQuantidade);
            }
        }
    }

    public void printEstoque(){
        for (ItemEstoque itemEstoque : this.listaEstoque){
            System.out.println("medicamento: " + itemEstoque.getMedicamento().getNome() + " / qnt: " + itemEstoque.getQntMedicamento());
            System.out.println("----------");
        }
    }
}
