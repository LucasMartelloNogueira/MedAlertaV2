package backend.farmacia;

import backend.Pessoa;
import backend.farmacia.Estoque;
import backend.usuario.PessoaFisica;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.*;

import backend.Agenda;
import backend.Autenticacao;
import backend.Endereco;
import backend.FuncoesArquivos;
import backend.Medicamento;

public class PessoaJuridica extends Pessoa{

    public static final String nomeArquivoFarmacias = "backend\\farmacia\\RegistroFarmacias.txt";
    
    private String cnpj;
    private Endereco endereco;
    private Estoque estoque;
    private Agenda contatosClientes;

    public PessoaJuridica(String nome, String telefone, String email, String senha, String cnpj, Endereco endereco){
        super(nome, telefone, email, senha);
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String novoCnpj, boolean modificarArquivo){
        this.cnpj = novoCnpj;
        if (modificarArquivo == true){
            FuncoesArquivos.alterarInfoArquivo(nomeArquivoFarmacias, this.getNome(), 4, novoCnpj);
        }
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setEndereco(Endereco novoEndereco, boolean modificarArquivo){
        this.endereco = novoEndereco;
        if (modificarArquivo == true){
            FuncoesArquivos.alterarInfoArquivo(nomeArquivoFarmacias, this.getNome(), 5, novoEndereco.toString());
        }
    }

    public Estoque getEstoque(){
        return this.estoque;
    }

    public void setEstoque(Estoque novoEstoque, boolean modificarArquivo){
        this.estoque = novoEstoque;
        if (modificarArquivo == true){
            this.salvarEstoqueArquivo();
        }
    }

    public Agenda getContatosClientes(){
        return this.contatosClientes;
    }

    public void setContatosClientes(Agenda novaAgenda, boolean modificarArquivo){
        this.contatosClientes = novaAgenda;
        if (modificarArquivo == true){
            FuncoesArquivos.alterarInfoArquivo(nomeArquivoFarmacias, this.getNome(), 7, this.getContatosClientes().toString());
        }
    }

    public void addUsuarioAosContatos(PessoaFisica usuario){
        Agenda agendaTemp;

        if (this.getContatosClientes() == null){
            agendaTemp = new Agenda();
        }
        else{
            agendaTemp = this.getContatosClientes();
        }
        
        agendaTemp.adicionarContato(usuario);
        this.setContatosClientes(agendaTemp, true);
    }

    //get e set particularidade 
    @Override
    public Object getParticularidade() {
        return getEndereco();
    }

    @Override
    public <T> void setParticularidade(T novaParticularidade) {
        setEndereco((Endereco)novaParticularidade, false);
    }

    @Override
    public String toString(){

        String farmaciaString = this.PessoaToString();

        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        
        if (this.getCnpj() != null){
            listaValoresAtributos.add(this.getCnpj());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getEndereco() != null){
            listaValoresAtributos.add(this.getEndereco().toString());
        }
        else{
            String enderecoNull = "null";
            listaValoresAtributos.add(enderecoNull);
        }

        if (this.getEstoque() != null){
            listaValoresAtributos.add(this.getNomeArquivoEstoque());
        }
        else{
            // a string que iria para lista seria o nome do arquivo do estoque, so precisa de um null
            listaValoresAtributos.add("null");
        }

        if (this.getContatosClientes() != null){
            listaValoresAtributos.add(getContatosClientes().toString());
        }
        else{
            // um null ja é fuciente para mostrar que a farmacia n tem contatos
            listaValoresAtributos.add("null");
        }
        
        String outrosValores = String.join(",", listaValoresAtributos);
        farmaciaString += "," + outrosValores;
        return farmaciaString;

    }

    public void salvarDadosArquivo(){
        List<String> listaLinha = new ArrayList<>();
        listaLinha.add(this.toString());
        FuncoesArquivos.salvarListaEmArquivo(nomeArquivoFarmacias, listaLinha, true);

    }

    public String getNomeArquivoEstoque(){
        String nomeArquivoEstoque = "backend\\farmacia\\estoquesFarmacias\\" + "Estoque" + this.getCnpj() + ".txt";
        return nomeArquivoEstoque;
    }

    public void salvarEstoqueArquivo(){
        try{
            String nomeArquivoEstoque = getNomeArquivoEstoque();
            FileWriter fw = new FileWriter(nomeArquivoEstoque);
            BufferedWriter bw = new BufferedWriter(fw); 
            
            Estoque estoqueTemp = this.getEstoque();
            for (ItemEstoque itemEstoque : estoqueTemp.listaEstoque){
                String linha = itemEstoque.toString();
                bw.write(linha);
                bw.newLine();
            }
            bw.close();
        }
        catch(IOException e){
            System.out.println("erro nao foi possivel salvar no arquivo");
            e.printStackTrace();
        }
    }

    public void adicionarMedicamentoEstoque(Medicamento medicamento, int quantidade){
        Estoque estoqueTemp = this.getEstoque();

        if (estoqueTemp == null){
            estoqueTemp = new Estoque();
        }

        estoqueTemp.addMedicamentoEstoque(medicamento, quantidade);
        this.setEstoque(estoqueTemp, true);
    }

    public void retirarMedicamentoEstoque(String nomeMedicamento){
        if (this.getEstoque() == null){
            return;
        }
        Estoque estoqueTemp = this.getEstoque();

        for (ItemEstoque itemEstoque : estoqueTemp.listaEstoque){
            if (itemEstoque.getMedicamento().getNome().equals(nomeMedicamento)){
                estoqueTemp.removerMedicamentoEstoque(itemEstoque);
                this.setEstoque(estoqueTemp, true);
            }
        }
    }

    public void atualizarQntMedicamentoEstoque(Medicamento medicamento, int novaQuantidade){
        if (this.getEstoque() == null){
            this.adicionarMedicamentoEstoque(medicamento, novaQuantidade);
        }

        Estoque estoqueTemp = this.getEstoque();

        for (ItemEstoque itemEstoque : estoqueTemp.listaEstoque){
            if (itemEstoque.getMedicamento().getNome().equals(medicamento.getNome())){
                estoqueTemp.atualizarQntMedicamento(medicamento, novaQuantidade);
                this.setEstoque(estoqueTemp, true);
            }
        }
    }
    
    public static Estoque resgatarEstoqueArquivo(String nomeArquivoEstoque){
        try{
            FileReader fr = new FileReader(nomeArquivoEstoque);
            BufferedReader br = new BufferedReader(fr);

            Estoque estoque = new Estoque();

            String linha = br.readLine();

            while (linha != null){
                ItemEstoque itemEstoque = ItemEstoque.stringToItemEstoque(linha);
                estoque.addMedicamentoEstoque(itemEstoque);
                linha = br.readLine();
            }
            System.out.println("estoque recuperado com sucesso!");
            br.close();
            return estoque;
        }
        catch (IOException e){
            System.out.println("erro, não é possível recuperar o estoque");
            e.printStackTrace();
            return null;
        }
    }

    public static PessoaJuridica resgatarFarmaciaArquivo(String emailFarmacia, String senhaFornecida, Boolean ignorarSenha, Boolean ignorarAgenda){
        try{
            FileReader fr = new FileReader(nomeArquivoFarmacias);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();

            while (linha != null){
                String[] dadosLinha = linha.split(",");
                String email = dadosLinha[2];
                String senha = dadosLinha[3];

                if (email.equals(emailFarmacia) && (ignorarSenha == true || senha.equals(senhaFornecida))){
                    String telefone = dadosLinha[1];
                    String nome = dadosLinha[0];
                    String cnpj = dadosLinha[4];
                    Endereco endereco = Endereco.stringToEndereco(dadosLinha[5]);

                    PessoaJuridica farmacia = new PessoaJuridica(nome, telefone, email, senha, cnpj, endereco);

                    if (!dadosLinha[6].equals("null")){
                        String nomeArquivoEstoque = dadosLinha[6];
                        Estoque estoque = resgatarEstoqueArquivo(nomeArquivoEstoque);
                        farmacia.setEstoque(estoque, false);
                    }

                    if (!dadosLinha[7].equals("null") && ignorarAgenda == false){
                        Agenda agenda = Agenda.stringToAgenda(dadosLinha[7], senha, "usuario", true, true);
                        farmacia.setContatosClientes(agenda, false);
                    }
                    br.close();
                    return farmacia;
                }
                
                linha = br.readLine();
            }
            System.out.println("erro, n foi possivel resgatar uma farmacia com esse nome");
            br.close();
            return null;
        }
        catch(Exception e){
            System.out.println("Erro, n foi possivel recuperar a farmacia do arquivo");
            e.printStackTrace();
            return null;
        }
    }
}
