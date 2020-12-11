
package backend.dsdesktopnotify;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Notificacao {
    
    public static void notificar() {
        Object option = "";
        DesktopNotify.showDesktopMessage("MedAlerta - Hora de tomar o seu remédio", "Você tem uma nova notificação. Clique aqui para visualizar.", DesktopNotify.TIP, new ActionListener(){@Override public void actionPerformed(ActionEvent evt){
            Object[] options = { "OK", "CANCELAR" };
            Object option = JOptionPane.showOptionDialog(null, "Sua notificação aqui", "MedAlerta - Hora de tomar o seu remédio", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            int op = Integer.parseInt(option.toString());
            
        }});
        // if(op==0){
        //     return true;
        // }
        // return false;
    }

    public static void main(String[] args) {
        
    }
}







// System.out.println(option);
            // Object[] possibleValues = { "First", "Second", "Third" };
            // Object selectedValue = JOptionPane.showInputDialog(null,
            // "Choose one", "Input",
            // JOptionPane.INFORMATION_MESSAGE, null,
            // possibleValues, possibleValues[0]);