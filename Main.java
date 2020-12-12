import backend.gerenciamento.Gerenciador;
import backend.gerenciamento.Notificacao;
import frontend.Inicio;

public class Main {
    public static void main(String[] args) {
        // thread para tela principal do aplicativo
        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();
        
        // thread para o gerenciador do aplicativo
        Gerenciador g = new Gerenciador();
        Thread gerenciador = new Thread(g);
        gerenciador.start();
        
        boolean t = Notificacao.notificar("Notificação Teste");
        System.out.println(t);
    }
}
