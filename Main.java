import backend.gerenciamento.Gerenciador;
import backend.gerenciamento.Notificacao;
import backend.usuario.PessoaFisica;
import frontend.Inicio;

public class Main {
    private static PessoaFisica pessoa;
    private static boolean emEspera = true;

    public static void setFimDaEspera(boolean emEspera, PessoaFisica pessoa) {
        Main.pessoa = pessoa;
        Main.emEspera = emEspera;
    }

    public static void main(String[] args) {
        // thread para tela principal do aplicativo
        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();

        while (emEspera) {
            try {
                Thread.sleep(10000); // dorme por 10 segundos
                System.out.println("Sistema em espera...");
            } catch (InterruptedException e) {}
        }
    
        // thread para o gerenciador do aplicativo
        Gerenciador.setFimDaEspera(false, pessoa);
        Gerenciador g = new Gerenciador();
        Thread gerenciador = new Thread(g);
        gerenciador.start();
        
        boolean t = Notificacao.notificar("Notificação Teste");
        System.out.println(t);
    }
}
