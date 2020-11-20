import frontend.Inicio;

public class Main {
    public static void main(String[] args) {
        //criar thread para tela principal
        //criar thread para gerenciador

        Inicio telaInicial = new Inicio();
        Thread interfaceComUsuario = new Thread(telaInicial);
        interfaceComUsuario.start();
    }
}
