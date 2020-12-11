package backend;

import java.util.ArrayList;

public class Endereco {
    private String nomeDaRua;
    private String numero;
    private String complemento;
    private String nomeDoBairro;
    private String nomeDaCidade;
    private String nomeDoEstado;
    private String nomeDoPais;
    private String cep;

    // construtores

    public Endereco(String nomeDaRua, String numero){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
    }

    public Endereco(String nomeDaRua, String numero, String complemento){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Endereco(String nomeDaRua, String numero, String complemento, String cep){
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Endereco(String nomeDaRua, String numero, String complemento, String nomeDoBairro, 
                    String nomeDaCidade, String nomeDoEstado, String nomeDoPais, String cep){
        
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.complemento = complemento;
        this.nomeDoBairro = nomeDoBairro;
        this.nomeDaCidade = nomeDaCidade;
        this.nomeDoEstado = nomeDoEstado;
        this.nomeDoPais = nomeDoPais;
        this.cep = cep;
    }

    // getters e setters

    public String getNomeDaRua(){
        return this.nomeDaRua;
    }

    public void setNomeDaRua(String novoNomeRua){
        this.nomeDaRua = novoNomeRua;
    }

    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String novoNumero){
        this.numero = novoNumero;
    }

    public String getComplemento(){
        return this.complemento;
    }

    public void setComplemento(String novoComplemento){
        this.complemento = novoComplemento;
    }

    public String getNomeDoBairro(){
        return this.nomeDoBairro;
    }

    public void setNomeDoBairro(String novoNomeDoBairro){
        this.nomeDoBairro = novoNomeDoBairro;
    }

    public String getNomeDaCidade(){
        return this.nomeDaCidade;
    }

    public void setNomeDaCidade(String novoNomeDaCidade){
        this.nomeDaCidade = novoNomeDaCidade;
    }

    public String getNomeDoEstado(){
        return this.nomeDoEstado;
    }

    public void setNomeDoEstado(String novoNomeDoEstado){
        this.nomeDoEstado = novoNomeDoEstado;
    }

    public String getNomeDoPais(){
        return this.nomeDoPais;
    }

    public void setNomeDoPais(String novoNomeDoPais){
        this.nomeDoPais = novoNomeDoPais;
    }

    public String getCep(){
        return this.cep;
    }

    public void setCep(String novoCep){
        this.cep = novoCep;
    }

    @Override
    public String toString(){
        ArrayList<String> listaValoresAtributos = new ArrayList<String>();
        listaValoresAtributos.add(this.getNomeDaRua());
        listaValoresAtributos.add(this.getNumero());

        if (this.getComplemento() != null){
            listaValoresAtributos.add(this.getComplemento());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getNomeDoBairro() != null){
            listaValoresAtributos.add(this.getNomeDoBairro());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getNomeDaCidade() != null){
            listaValoresAtributos.add(this.getNomeDaCidade());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getNomeDoEstado() != null){
            listaValoresAtributos.add(this.getNomeDoEstado());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getNomeDoPais() != null){
            listaValoresAtributos.add(this.getNomeDoPais());
        }
        else{
            listaValoresAtributos.add("null");
        }

        if (this.getCep() != null){
            listaValoresAtributos.add(this.getCep());
        }
        else{
            listaValoresAtributos.add("null");
        }

        String enderecoString = String.join("/", listaValoresAtributos);
        return enderecoString;
    }

    public String toStringFront(){
        String enderecoStringCompleto = this.toString();
        String[] dadosEndereco = enderecoStringCompleto.split("/");
        ArrayList<String> listaTemp = new ArrayList<>();

        for (String s : dadosEndereco){
            if (!s.equals("null")){
                listaTemp.add(s);
            }
        }

        String enderecoStringFront = String.join(",", listaTemp);
        return enderecoStringFront;
    }

    public static Endereco stringToEndereco(String enderecoString){
        String[] dadosEndereco = enderecoString.split("/");
        Endereco endereco = new Endereco(dadosEndereco[0], dadosEndereco[1]);

        for (int i = 2; i < 8; i++){
            if (dadosEndereco[i] != "null"){
                switch (i){
                    case 2:
                        endereco.setComplemento(dadosEndereco[i]);
                        break;
                    case 3:
                        endereco.setNomeDoBairro(dadosEndereco[i]);
                        break;
                    case 4:
                        endereco.setNomeDaCidade(dadosEndereco[i]);
                        break;
                    case 5:
                        endereco.setNomeDoEstado(dadosEndereco[i]);
                        break;
                    case 6:
                        endereco.setNomeDoPais(dadosEndereco[i]);
                        break;
                    case 7:
                        endereco.setCep(dadosEndereco[i]);
                        break;
                }
            }
        }
        return endereco;
    }
}
