package backend.gerenciamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import backend.dsdesktopnotify.DesktopNotify;

public class Notificacao {
    private static Integer option = -1;

    // método chamado para enviar uma notificação ao usuário
    // o retorno é um true, caso o usuário tenha executado a ação notificada, e
    // false, caso contrário
    public static boolean notificar(String notificacao) {
        DesktopNotify.showDesktopMessage("MedAlerta - Hora de tomar o seu remédio",
            "Você tem uma nova notificação. Clique aqui para visualizar.", DesktopNotify.TIP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Object[] options = { "SIM", "NÃO" };
                Integer option = JOptionPane.showOptionDialog(null, notificacao,
                        "MedAlerta - Hora de tomar o seu remédio", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                Notificacao.option = Integer.parseInt(option.toString());
            }
        });

        while(option==-1){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //System.out.println("oiiiiiiiiiiii");
            }
        }

        if(option==0){
            option = -1; //impedir que decremente em uma unidade do estoque a todo momento
            //System.out.println("oiiiiiiiiiiii2");
            return true;
        }
        //System.out.println("oiiiiiiiiiiii3");
        return false;
    }

    public static void notificarCompra(String notificacao) {
        DesktopNotify.showDesktopMessage("MedAlerta - Hora de comprar o seu remédio",
            "Você tem uma nova notificação. Clique aqui para visualizar.", DesktopNotify.TIP, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    JOptionPane.showMessageDialog(null, notificacao, "MedAlerta - Hora de tomar o seu remédio", 1);
                }
            }
        );
    }
}
