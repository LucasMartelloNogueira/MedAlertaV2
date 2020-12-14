package backend.usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import backend.Agenda;
import backend.Autenticacao;
import backend.Endereco;
import backend.FuncoesArquivos;
import backend.Pessoa;
import backend.SalvavelBancoDeDados;
import backend.farmacia.PessoaJuridica;

public class PessoaFisica extends Pessoa implements SalvavelBancoDeDados{

    public static final String nomeArquivoUsuarios = "backend\\usuario\\RegistroUsuarios.txt";
    
    private String cpf;
    private Endereco endereco;
    private List<Uso> listaUsoMedicamentos;
    private Agenda contatosMedicos = new Agenda();
    private Agenda contatosFarmacias = new Agenda();


    public PessoaFisica(String nome, String telefone, String email, String cpf, String senha, Endereco endereco) {
        super(nome, telefone, email, senha);
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // getters e setters
    
    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String novoCpf){
        this.cpf = novoCpf;
    }

    public List<Uso> getListaUsoMedicamentos(){
        return this.listaUsoMedicamentos;
    }

    public void setListaUsoMedicamentos(List<Uso> novaLista, boolean modificarArquivo){
        this.listaUsoMedicamentos = novaLista;
        if (modificarArquivo == true){
            this.salvarArquivoUsos();
        }
    }

    public void adicionarUsoNaListaUsoMedicamentos(Uso novoUso){
        List<Uso> listaUsoTemp = this.getListaUsoMedicamentos();

        if(this.getListaUsoMedicamentos() == null){
            listaUsoTemp = new ArrayList<>();
        }

        listaUsoTemp.add(novoUso);
        this.setListaUsoMedicamentos(listaUsoTemp, true);
    }

    public void removerUsoNaListaUsoMedicamentos(String nomeMedicamento){
        List<Uso> listaUsoTemp = this.getListaUsoMedicamentos();

        if(this.getListaUsoMedicamentos() == null){
            return;
        }

        for (Uso uso : this.getListaUsoMedicamentos()){
            if (uso.getRemedio().getNome().equals(nomeMedicamento)){
                listaUsoTemp.remove(uso);
                break;
            }
        }
        this.setListaUsoMedicamentos(listaUsoTemp, true);
    }

    public void atualizarQntRemediosListaUsoMedicamentos(String nomeMedicamento, int novaQuantidade){
        List<Uso> listaUsoTemp = this.getListaUsoMedicamentos();

        if(this.getListaUsoMedicamentos() == null){
            System.out.println("lista de uso de medicamentos vazia");
            return;
        }

        for (Uso uso : listaUsoTemp){
            if (uso.getRemedio().getNome().equals(nomeMedicamento)){
                System.out.println("ACHOU");
                uso.setQtdDisponivel(novaQuantidade);
                break;
            }
        }
        this.setListaUsoMedicamentos(listaUsoTemp, true);
    }

    public Uso getUsoListaUsoMedicamentos(String nomeMedicamento){
        List<Uso> listaUsoTemp = this.getListaUsoMedicamentos();

        if (listaUsoTemp == null){
            return null;
        }

        for (Uso uso : listaUsoTemp){
            if (uso.getRemedio().getNome().equals(nomeMedicamento)){
                return uso;
            }
        }
        return null;

    }

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

    public void setContatosMedicos(Agenda contatosMedicos, boolean modificarArquivo){
        this.contatosMedicos = contatosMedicos;
        if (modificarArquivo == true){
            this.salvarDadosArquivo();
        }
    }

    public Agenda getContatosFarmacias(){
        return this.contatosFarmacias;
    }

    public void setContatosFarmacias(Agenda contatosFarmacias){
        this.contatosFarmacias = contatosFarmacias;
    }
    
    public void setContatosFarmacias(Agenda contatosFarmacias, boolean modificarArquivo){
        this.contatosFarmacias = contatosFarmacias;
        if (modificarArquivo == true){
            this.salvarDadosArquivo();
        }
    }

    public void salvarArquivoUsos(){
        ArrayList<String> listaLinhas = new ArrayList<>();
        
        for (Uso uso : this.getListaUsoMedicamentos()){
            String usoString = uso.toString();
            listaLinhas.add(usoString);
        }

        FuncoesArquivos.salvarListaEmArquivo(this.getNomeArquivoUsos(), listaLinhas, false);
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
        this.setContatosFarmacias(agendaTemp, true);
    }

    public void removerContatoFarmacia(String nomeFarmacia){
        Agenda agendaTemp = this.getContatosFarmacias();

        if (agendaTemp == null){
            return;
        }

        for (Pessoa contatoFarmacia : this.getContatosFarmacias().getContatos()){
            if (contatoFarmacia.getNome().equals(nomeFarmacia)){
                agendaTemp.removerContato(nomeFarmacia);
                break;
            }
        }
        this.setContatosFarmacias(agendaTemp, true);
    }

    public void adicionarContatoMedico(Medico medico){
        Agenda agendaTemp;

        if (this.getContatosMedicos() == null){
            agendaTemp = new Agenda();
        }
        else{
            agendaTemp = this.getContatosMedicos();
        }

        agendaTemp.adicionarContato(medico);
        this.setContatosMedicos(agendaTemp, true);

    }

    public void removerContatoMedico(String nomeMedico){
        Agenda agendaTemp = this.getContatosMedicos();

        if (agendaTemp == null){
            return;
        }

        for (Pessoa contatoMedico : this.getContatosMedicos().getContatos()){
            if (contatoMedico.getNome().equals(nomeMedico)){
                agendaTemp.removerContato(nomeMedico);
                break;
            }
        }
        this.setContatosMedicos(agendaTemp, true);
    }

    public static String getNomeArquivoUsuarios(){
        return nomeArquivoUsuarios;
    }

    public String getNomeArquivoUsos(){
        return "backend\\usuario\\arquivosUsosUsuarios\\" + "Uso" + this.getCpf() + ".txt";
    }

    @Override
    public String toString(){

        String usuarioString = this.PessoaToString();

        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        listaValoresAtributos.add(this.getCpf());
        listaValoresAtributos.add(this.getEndereco().toString());

        if (this.getListaUsoMedicamentos() != null){
            listaValoresAtributos.add(this.getNomeArquivoUsos());
        }
        else{
            listaValoresAtributos.add("null");
        }

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

    public String toString(boolean encriptarSenha){

        String usuarioString = this.PessoaToString(encriptarSenha);

        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        listaValoresAtributos.add(this.getCpf());
        listaValoresAtributos.add(this.getEndereco().toString());

        if (this.getListaUsoMedicamentos() != null){
            listaValoresAtributos.add(this.getNomeArquivoUsos());
        }
        else{
            listaValoresAtributos.add("null");
        }

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
        boolean usuarioJaExiste = FuncoesArquivos.checarExistenciaNomeArquivo(PessoaFisica.getNomeArquivoUsuarios(), this.getNome());
        if (usuarioJaExiste == false){
            System.out.println("usuario NAO existe");
            FuncoesArquivos.appendLinhaArquivo(PessoaFisica.getNomeArquivoUsuarios(), this.toString());
        }
        else{
            System.out.println("usuario JA existe");
            FuncoesArquivos.alterarLinhaArquivo(PessoaFisica.getNomeArquivoUsuarios(), this.getNome(), this.toString());
        }
    }

    public static List<Uso> resgatarListaUsoMedicamentosArquivo(String nomeArquivo){

        List<Uso> listaUsoMedicamentos = new ArrayList<>();

        List<String> listaLinhas = FuncoesArquivos.obterListaLinhas(nomeArquivo);
        
        for (String linha : listaLinhas){
            Uso uso = Uso.stringToUso(linha);
            listaUsoMedicamentos.add(uso);
        }

        return listaUsoMedicamentos;
    }

    public static PessoaFisica resgatarUsuarioArquivo(String emailFornecido, String senhaFornecida, Boolean ignorarSenha, Boolean ignorarAgenda){
        try{
            FileReader fr = new FileReader(nomeArquivoUsuarios);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();

            while(linha != null){
                String[] dadosLinha = linha.split(",");
                String email = dadosLinha[2];
                String senha = dadosLinha[3];

                if (email.equals(emailFornecido) && (ignorarSenha == true || senha.equals(senhaFornecida))){
                    String telefone = dadosLinha[1];
                    String nome = dadosLinha[0];
                    String cpf = dadosLinha[4];
                    String enderecoString = dadosLinha[5];
                    Endereco endereco = Endereco.stringToEndereco(enderecoString);
                    PessoaFisica usuario = new PessoaFisica(nome, telefone, email, cpf, senha, endereco);
                    
                    if (!dadosLinha[6].equals("null")){
                        List<Uso> listaUsoMedicamentos = resgatarListaUsoMedicamentosArquivo(dadosLinha[6]);
                        usuario.setListaUsoMedicamentos(listaUsoMedicamentos , false);
                    }

                    if (!dadosLinha[7].equals("null") && ignorarAgenda == false){
                        usuario.setContatosMedicos(Agenda.stringToAgenda(dadosLinha[7], senha, "medico", true, true));
                    }

                    if (!dadosLinha[8].equals("null")){
                        usuario.setContatosFarmacias(Agenda.stringToAgenda(dadosLinha[8], senha, "farmacia", true, true));
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

    public boolean estabelecerConexaoBD(String pathBancoDeDados){
        return true;
    }

    public void salvarObejtoBancoDeDados(Object obejto){
        // salva objeto no arquivo
        return;
    }

    public Object recuperarObjetoBancoDeDados(String pathBancoDeDados){
        // recupera objeto do arquivo
        Object o = null;
        return o;
    }
}
