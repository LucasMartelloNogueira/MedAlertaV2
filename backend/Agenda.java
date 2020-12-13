package backend;

import java.util.ArrayList;
import java.util.Collections;

import backend.farmacia.PessoaJuridica;
import backend.usuario.Medico;
import backend.usuario.PessoaFisica;

public class Agenda {
    private ArrayList<Pessoa> contatos = new ArrayList<>();

    // encontra a posicao do contato na agenda
    private int encontraContato(String nome) {
        int i = 0;
        for (Pessoa contato : this.contatos) {
            if (contato.getNome().equals(nome))
                return i;
            i++;
        }
        return -1;
    }

    // adiciona o contato a agenda
    public void adicionarContato(Pessoa contato) throws IllegalArgumentException {
        if (contato == null) {
            throw new IllegalArgumentException("É necessário informar um contato válido");
        } else {
            contatos.add(contato);
            System.out.println("Contato Adicionado!");
        }
    }

    // busca o contato na agenda e altera seu telefone
    boolean alterarNomeContato(String nome, String novoNome) {
        int pos = encontraContato(nome);
        if (pos == -1) {
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } else {
            contatos.get(pos).setNome(novoNome);
            System.out.println("O nome de " + contatos.get(pos).getNome() + " foi alterado!");
        }
        return true;
    }

    // busca o contato na agenda e altera seu telefone
    public boolean alterarTelContato(String nome, String novoTelefone) {
        int pos = encontraContato(nome);
        if (pos == -1) {
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } else {
            contatos.get(pos).setTelefone(novoTelefone);
            System.out.println("O telefone de " + contatos.get(pos).getNome() + " foi alterado!");
        }
        return true;
    }

    // busca o contato na agenda e altera seu endereco ou especialidade
    public <T> boolean alterarParticularidadeContato(String nome, T novaParticularidade) {
        int pos = encontraContato(nome);
        if (pos == -1) {
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } else {
            contatos.get(pos).setParticularidade(novaParticularidade);
            ;
            System.out.println("O atributo de " + contatos.get(pos).getNome() + " foi alterado!");
        }
        return true;
    }

    // busca o contato na agenda e altera seu email
    public boolean alterarEmailContato(String nome, String novoEmail) {
        int pos = encontraContato(nome);
        if (pos == -1) {
            System.out.println("Contato não encontrado! A alteração não foi realizada.");
            return false;
        } else {
            contatos.get(pos).setEmail(novoEmail);
            ;
            System.out.println("O endereço de " + contatos.get(pos).getNome() + " foi alterado!");
        }
        return true;
    }

    // busca o contato na agenda e o remove
    public boolean removerContato(String nome) {
        int pos = encontraContato(nome);
        if (pos == -1) {
            System.out.println("Contato não encontrado!");
            return false;
        } else {
            ArrayList<Pessoa> novaLista = this.getContatos();
            
            for (Pessoa contato : this.getContatos()){
                if (contato.getNome().equals(nome)){
                    novaLista.remove(contato);
                    break;
                }
            }
            this.setContatos(novaLista);
        }
        return true;
    }

    // ordena lista de contatos pelo nome para exibi-la na tela
    private void ordenarListaDeContatos() {
        Collections.sort(contatos); // ================== > a atualizar
    }

    //get contatos
    public ArrayList<Pessoa>getContatos() {
        ordenarListaDeContatos();
        return contatos;
    }

    public void setContatos(ArrayList<Pessoa> novosContatos){
        this.contatos = novosContatos;
    }

    @Override
    public String toString(){

        if (this.getContatos().size() == 0){
            return "null";
        }
        else{
            ArrayList<String> listaNomesAgenda = new ArrayList<String>();
        
        for (Pessoa pessoa : this.contatos){
            listaNomesAgenda.add(pessoa.getEmail());
        }

        String contatosString = String.join("/", listaNomesAgenda);
        return contatosString;
        }
    }

    public static Agenda stringToAgenda(String agendaString, String senhaFornecida, String tipoContato, Boolean ignorarSenha, Boolean ignorarAgenda){
        Agenda agenda = new Agenda();
        String[] nomeContatos = agendaString.split("/");

        for (String nome : nomeContatos){
            if (tipoContato.equals("usuario")){
                PessoaFisica contato = PessoaFisica.resgatarUsuarioArquivo(nome, senhaFornecida, ignorarSenha, ignorarAgenda);
                agenda.adicionarContato(contato);
            }
            if (tipoContato.equals("farmacia")){
                PessoaJuridica farmacia = PessoaJuridica.resgatarFarmaciaArquivo(nome, senhaFornecida, ignorarSenha, ignorarAgenda);
                agenda.adicionarContato(farmacia);
            }

            if (tipoContato.equals("medico")){
                Medico medico = Medico.resgatarMedicoArquivo(nome, senhaFornecida, ignorarSenha);
                agenda.adicionarContato(medico);
            }
        }
        return agenda;
    }
}
