package backend;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.io.*;

//pessoa no sentido de pessoa fisica ou pessoa juridica
public abstract class Pessoa implements Comparable<Pessoa>, Serializable {
    private String nome; // nome da pessoa ou razao social
    private String telefone;
    private String email;
    private String senha;

    // construtores
    public Pessoa(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    // get Nome
    public String getNome() {
        return this.nome;
    }

    // set nome
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    // get telefone
    public String getTelefone() {
        return this.telefone;
    }

    // set telefone
    public void setTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
    }

    // get email
    public String getEmail() {
        return this.email;
    }

    // set email
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public abstract Object getParticularidade(); // get endereco se pessoa fisica ou juridica OU get especialidade se
                                                 // medico

    public abstract <T> void setParticularidade(T novaParticularidade); // set endereco se pessoa fisica ou juridica OU
                                                                        // set especialidade se medico

    public int compareTo(Pessoa outraPessoa) {
        /*
         * if(this.getNome().compareTo(outraPessoa.getNome()) > 0) return 1;
         * if(this.getNome().compareTo(outraPessoa.getNome()) < 0) return -1; return 0;
         */
        return this.getNome().compareTo(outraPessoa.getNome());
    }

    public String PessoaToString() {
        ArrayList<String> listaValoresAtributos = new ArrayList<String>();

        listaValoresAtributos.add(this.getNome());
        listaValoresAtributos.add(this.getTelefone());
        listaValoresAtributos.add(this.getEmail());
        listaValoresAtributos.add(this.getSenha());
        
        String pessoaString = String.join(",", listaValoresAtributos);
        return pessoaString;
    }

    public String PessoaToString(Boolean botarSenhaEncriptada) {
        ArrayList<String> listaValoresAtributos = new ArrayList<String>();

        listaValoresAtributos.add(this.getNome());
        listaValoresAtributos.add(this.getTelefone());
        listaValoresAtributos.add(this.getEmail());
        String senhaEncriptada = "";
        
        if (botarSenhaEncriptada == true){
            try {
                senhaEncriptada = Autenticacao.encriptarSenha(this.getEmail(), this.getSenha());
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            listaValoresAtributos.add(senhaEncriptada);
        }
        else{
            listaValoresAtributos.add(this.getSenha());
        }
        
        String pessoaString = String.join(",", listaValoresAtributos);
        return pessoaString;
    }

    // função para gravar objeto no arquivo
    public void salvarObjetoArquivo(String nomeArquivo, Object objeto){
        try{
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objetoOut = new ObjectOutputStream(arquivo);
            objetoOut.writeObject(objeto);
            objetoOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //função para resgatar objeto do arquivo
    public Object recuperarObjetoArquivo(String nomeArquivo){
        try{
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream objetoIn = new ObjectInputStream(arquivo);
            Object objeto = objetoIn.readObject();
            objetoIn.close();
            return objeto;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        
    }

}
