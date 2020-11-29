package backend.farmacia;

import backend.Pessoa;
import backend.farmacia.Estoque;
import backend.usuario.PessoaFisica;

import java.util.ArrayList;
import java.io.*;

import backend.Agenda;
import backend.Endereco;

public class PessoaJuridica extends Pessoa{

    public static final String nomeArquivoFarmacias = "RegistroFarmacias.txt";

    private String cnpj;
    private Endereco endereco;
    private Estoque estoque;
    private Agenda contatosClientes;


    public PessoaJuridica(String nome, String telefone, String email){
        super(nome, telefone, email);
    }

    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String novoCnpj){
        this.cnpj = novoCnpj;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Estoque getEstoque(){
        return this.estoque;
    }

    public void setEstoque(Estoque novoEstoque){
        this.estoque = novoEstoque;
    }

    public Agenda getContatosClientes(){
        return this.contatosClientes;
    }

    public void setContatosClientes(Agenda novaAgenda){
        this.contatosClientes = novaAgenda;
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
        this.setContatosClientes(agendaTemp);
    }

    //get e set particularidade 
    @Override
    public Object getParticularidade() {
        return getEndereco();
    }

    @Override
    public <T> void setParticularidade(T novaParticularidade) {
        setEndereco((Endereco)novaParticularidade);
    }

    @Override
    public String toString(){
        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        listaValoresAtributos.add(this.getNome());
        listaValoresAtributos.add(this.getTelefone());
        listaValoresAtributos.add(this.getEmail());

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
            // classe Endereco tem 8 atributos, entao precisamos botar 8 nulls na lista
            String enderecoNull = "null";
            listaValoresAtributos.add(enderecoNull);
        }

        if (this.getEstoque() != null){
            listaValoresAtributos.add(this.getEstoque().toString());
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
        
        String farmaciaString = String.join(",", listaValoresAtributos);
        return farmaciaString;

    }

    public void salvarDadosArquivo(){
        try{
            FileWriter fw = new FileWriter(nomeArquivoFarmacias, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.toString());
            bw.newLine();
            bw.close();
            System.out.println("farmacia salva no arquivo com sucesso!");
        }
        catch (IOException e){
            System.out.println("erro, n foi possivel salvar os dados da farmacia no arquivo");
            e.printStackTrace();
        }
    }

    public String getNomeArquivoEstoque(){
        String nomeArquivoEstoque = "Estoque" + this.getCnpj() + ".txt";
        return nomeArquivoEstoque;
    }

    public void salvarEstoqueArquivo(){
        try{
            String nomeArquivoEstoque = getNomeArquivoEstoque();
            FileWriter fw = new FileWriter(nomeArquivoEstoque, true);
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

    public static PessoaJuridica resgatarFarmaciaArquivo(String nomeFarmacia, Boolean ignorarAgenda){
        try{
            FileReader fr = new FileReader(nomeArquivoFarmacias);
            BufferedReader br = new BufferedReader(fr);
            String linha = br.readLine();

            while (linha != null){
                String[] dadosLinha = linha.split(",");
                String nome = dadosLinha[0];

                if (nome.equals(nomeFarmacia)){
                    PessoaJuridica farmacia = new PessoaJuridica(dadosLinha[0], dadosLinha[1], dadosLinha[2]);

                    if (!dadosLinha[3].equals("null")){
                        farmacia.setCnpj(dadosLinha[3]);
                    }

                    if (!dadosLinha[4].equals("null")){
                        Endereco endereco = Endereco.stringToEndereco(dadosLinha[4]);
                        farmacia.setEndereco(endereco);
                    }

                    if (!dadosLinha[5].equals("null")){
                        String nomeArquivoEstoque = dadosLinha[5];
                        Estoque estoque = resgatarEstoqueArquivo(nomeArquivoEstoque);
                        farmacia.setEstoque(estoque);
                    }

                    if (!dadosLinha[6].equals("null") && ignorarAgenda == false){
                        Agenda agenda = Agenda.stringToAgenda(dadosLinha[6], "usuario", true);
                        farmacia.setContatosClientes(agenda);
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
        catch(IOException e){
            System.out.println("Erro, n foi possivel recuperar a farmacia do arquivo");
            e.printStackTrace();
            return null;
        }
    }
}
