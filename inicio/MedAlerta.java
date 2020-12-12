package inicio;

import backend.gerenciamento.Gerenciador;
//import backend.gerenciamento.Notificacao;
import backend.usuario.PessoaFisica;
import frontend.Inicio;
import frontend.Home;

public class MedAlerta {
    private static PessoaFisica pessoa = null;
    private static boolean emEspera = true;
    private static boolean usuarioPessoa = true; // quem esta logado é pessoa fisica ou juridica?

    //utilizado para devolver objeto pessoa ao main para que seja utilizado por outras threads
    public static void setFimDaEspera(boolean emEspera, PessoaFisica pessoa) {
        MedAlerta.pessoa = pessoa;
        MedAlerta.emEspera = emEspera;
    }

    //utilizado para devolver objeto pessoa ao main para que seja utilizado por outras threads
    public static void setFimDaEspera(boolean emEspera) {
        MedAlerta.emEspera = emEspera;
        MedAlerta.usuarioPessoa = false;
    }

    public static void main(String[] args) {
        // thread para tela principal do aplicativo
        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();

        while (emEspera) {
            try {
                Thread.sleep(2000); // dorme por 2 segundos
                System.out.println("Sistema em espera..."); //esperando login
            } catch (InterruptedException e) {}
        }

        // thread para iniciar a tela home
        if(usuarioPessoa){
            Home tela = new Home();
            tela.receber(MedAlerta.pessoa);
            tela.setVisible(true);
        }
    
        // thread para o gerenciador do aplicativo
        if(usuarioPessoa){
            Gerenciador.setPessoa(pessoa);
            Gerenciador g = new Gerenciador();
            Thread gerenciador = new Thread(g);
            gerenciador.start();
        }

        // boolean t = Notificacao.notificar("Notificação Teste");
        // System.out.println(t);
    }
}
