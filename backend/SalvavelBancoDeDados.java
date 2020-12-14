package backend;

public interface SalvavelBancoDeDados {
    // função que faria a conexão com o banco de dados
    // retorna true se conectou e false se não conseguiu
    public abstract boolean estabelecerConexaoBD(String pathBancoDeDados);

    // salva o objeto
    public abstract void salvarObejtoBancoDeDados(Object obejto);

    // recupera o objeto do banco de dados
    public abstract Object recuperarObjetoBancoDeDados(String pathBancoDeDados);
}
