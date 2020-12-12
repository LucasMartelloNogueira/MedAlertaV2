package backend.gerenciamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import backend.dsdesktopnotify.DesktopNotify;

public class Notificacao {
    private static int op = -1;

    // método chamado para enviar uma notificação ao usuário
    // o retorno é um true, caso o usuário tenha executado a ação notificada, e
    // false, caso contrário
    public static boolean notificar(String notificacao) {
        DesktopNotify.showDesktopMessage("MedAlerta - Hora de tomar o seu remédio",
                "Você tem uma nova notificação. Clique aqui para visualizar.", DesktopNotify.TIP, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Object[] options = { "SIM", "NÃO" };
                        Object option = JOptionPane.showOptionDialog(null, notificacao,
                                "MedAlerta - Hora de tomar o seu remédio", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                        Notificacao.op = Integer.parseInt(option.toString());
                    }
                });

        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(op==0){
            return true;
        }
        return false;
    }
}
