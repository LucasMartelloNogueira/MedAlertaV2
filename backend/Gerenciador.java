package backend;

import java.util.ArrayList;
import backend.usuario.Uso;

public class Gerenciador {
    ArrayList<Uso> listaDeUsos = new ArrayList<>(); //lista ordenada por horários de uso

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for(int i = 0; i < 10; i++)
                System.out.println("programa 1 valor " + i);
        };

        Runnable r2 = () -> {
            for(int i = 0; i < 10; i++)
                System.out.println("programa 2 valor " + i);
        };

        Thread teste = new Thread(r);
        Thread teste2 = new Thread(r2);
        teste.start();
        teste2.start();
        
        try{
            teste.sleep(20000);
        }catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void emitirAlerta(){
        //alguma coisa aqui
    }

    public static void atualizarListaDeUsos(){
        //alguma coisa aqui
    }
}
