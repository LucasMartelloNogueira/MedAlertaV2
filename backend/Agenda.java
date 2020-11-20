package backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
    private List<Contactavel> contatos = new ArrayList<Contactavel>();

    // encontra a posicao do contato na agenda
    private int encontraContato(String nome) {
        int i = 0;
        for (Contactavel contato : contatos) {
            if (contato.getNome().equals(nome))
                return i;
            i++;
        }
        return -1;
    }

    // adiciona o contato a agenda
    public void adicionarContato(Contactavel contato) throws IllegalArgumentException {
        if (contato == null) {
            throw new IllegalArgumentException("É necessário informar um contato válido");
        } else {
            contatos.add(contato);
            System.out.println("Contato Adicionado!");
        }
    }

    //busca o contato na agenda e altera seu telefone
    boolean alterarNomeContato(String nome, String novoNome){        
        int pos = encontraContato(nome);
        if(pos == -1){
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } 
        else{
            contatos.get(pos).setNome(novoNome);
            System.out.println("O nome de "+contatos.get(pos).getNome()+" foi alterado!");
        }
        return true;
    }

    //busca o contato na agenda e altera seu telefone
    public boolean alterarTelContato(String nome, String novoTelefone){        
        int pos = encontraContato(nome);
        if(pos == -1){
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } 
        else{
            contatos.get(pos).setTelefone(novoTelefone);
            System.out.println("O telefone de "+contatos.get(pos).getNome()+" foi alterado!");
        }
        return true;
    }

    //busca o contato na agenda e altera seu endereco
    public  <T> boolean alterarParticularidadeContato(String nome, T novaParticularidade){        
        int pos = encontraContato(nome);
        if(pos == -1){
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } 
        else{
            contatos.get(pos).setParticularidade(novaParticularidade);;
            System.out.println("O atributo de "+contatos.get(pos).getNome()+" foi alterado!");
        }
        return true;
    }

    //busca o contato na agenda e altera seu email
    public boolean alterarEmailContato(String nome, String novoEmail){        
        int pos = encontraContato(nome);
        if(pos == -1){
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } 
        else{
            contatos.get(pos).setEmail(novoEmail);;
            System.out.println("O endereço de "+contatos.get(pos).getNome()+" foi alterado!");
        }
        return true;
    }

    //busca o contato na agenda e o remove
    public boolean removerContato(String nome){        
        int pos = encontraContato(nome);
        if(pos == -1){
            System.out.println("Contato não encontrado!");
            return false;
        } 
        else{
            contatos.remove(pos);
            System.out.println("O telefone de "+contatos.get(pos).getNome()+" foi removido!");
        }
        return true;
    }

    // ordena lista de contatos pelo nome para exibi-la na tela
    private void ordenarListaDeContatos() {
       //Collections.sort(contatos);                              ================== > a atualizar 
    }

    //get contatos
    public List<Contactavel> getContatos() {
        ordenarListaDeContatos();
        return contatos;
    }
}
