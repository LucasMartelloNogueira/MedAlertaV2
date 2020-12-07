package backend.usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import backend.Agenda;
import backend.Contactavel;
import backend.Endereco;
import backend.Pessoa;
import backend.farmacia.PessoaJuridica;

public class PessoaFisica extends Pessoa {

    public static final String nomeArquivoUsuarios = "backend\\usuario\\RegistroUsuarios.txt";
    
    private Endereco endereco;
    private Agenda contatosMedicos = new Agenda();
    private Agenda contatosFarmacias = new Agenda();
    //lista de usos

    public PessoaFisica(String nome, String telefone, String email, String senha, Endereco endereco) {
        super(nome, telefone, email, senha);
        this.endereco = endereco;
    }

    //get e set
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Agenda getContatosMedicos() {
        return this.contatosMedicos;
    }

    public void setContatosMedicos(Agenda contatosMedicos){
        this.contatosMedicos = contatosMedicos;
    }

    public Agenda getContatosFarmacias(){
        return this.contatosFarmacias;
    }

    public void setContatosFarmacias(Agenda contatosFarmacias){
        this.contatosFarmacias = contatosFarmacias;
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

    public void addFarmaciaAosContatos(PessoaJuridica farmacia){

        Agenda agendaTemp;

        if (this.getContatosFarmacias() == null){
            agendaTemp = new Agenda();
        }
        else{
            agendaTemp = this.getContatosFarmacias();
        }

        agendaTemp.adicionarContato(farmacia);
        this.setContatosFarmacias(agendaTemp);
    }

    public static String getNomeArquivoUsuarios(){
        return nomeArquivoUsuarios;
    }

    @Override
    public String toString(){

        String usuarioString = this.PessoaToString();

        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        
        listaValoresAtributos.add(this.getEndereco().toString());

        if (this.getContatosMedicos() != null){
            listaValoresAtributos.add(this.getContatosMedicos().toString());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getContatosFarmacias() != null){
            listaValoresAtributos.add(this.getContatosFarmacias().toString());    
        }
        else{
            listaValoresAtributos.add("null");
        }

        String outrosValores = String.join(",", listaValoresAtributos);
        usuarioString += "," + outrosValores;
        return usuarioString;
    }

    public void salvarDadosArquivo(){
        try{
            FileWriter fw = new FileWriter(getNomeArquivoUsuarios(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.toString());
            bw.newLine();
            bw.close();
            System.out.println("usuario salvo com sucesso!");
        }
        catch (IOException e){
            System.out.println("erro, não foi possível salvar os dados no arquivo");
            e.printStackTrace();
        }
    }

    public static PessoaFisica resgatarUsuarioArquivo(String nomePessoa, String senhaFornecida, Boolean ignorarSenha, Boolean ignorarAgenda){
        try{
            FileReader fr = new FileReader(getNomeArquivoUsuarios());
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while(linha != null){
                String[] dadosLinha = linha.split(",");
                String nome = dadosLinha[0];
                String senha = dadosLinha[3];

                if (nome.equals(nomePessoa) && (ignorarSenha == true || senhaFornecida.equals(senha))){
                    String telefone = dadosLinha[1];
                    String email = dadosLinha[2];
                    String enderecoString = dadosLinha[4];
                    Endereco endereco = Endereco.stringToEndereco(enderecoString);
                    PessoaFisica usuario = new PessoaFisica(nome, telefone, email, senha, endereco);
                    
                    if (!dadosLinha[5].equals("null") && ignorarAgenda == false){
                        usuario.setContatosMedicos(Agenda.stringToAgenda(dadosLinha[5], senha, "medico", true, true));
                    }

                    if (!dadosLinha[6].equals("null")){
                        usuario.setContatosFarmacias(Agenda.stringToAgenda(dadosLinha[6], senha, "farmacia", true, true));
                    }

                    br.close();
                    return usuario;
                }
                linha = br.readLine();
            }
            System.out.println("n foi possivel achar uma pessoa com esse nome");
            br.close();
            return null;
        }
        catch(Exception e){
            System.out.println("erro, n foi possivel resgatar o usuario do arquivo");
            e.printStackTrace();
            return null;
        }
    }
}
