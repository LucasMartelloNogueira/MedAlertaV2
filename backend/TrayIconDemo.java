package backend;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

public class TrayIconDemo implements Runnable {

    public static void main(String[] args) throws AWTException {

        

        char[] a = {'m','n','x'};
        String b = String.copyValueOf(a);
        System.out.println(b);


        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
        } else {
            System.err.println("System tray not supported!");
        }
    }

    public void displayTray() throws AWTException {
        // Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        // If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        // Alternative (if the icon is on the classpath):
        // Image image =
        // Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        // Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        // Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("Med Alerta - Hora de tomar o seu remédio", "notification demo", MessageType.NONE);
    }

    @Override
    public void run() {

        

        if (SystemTray.isSupported()) {
            TrayIconDemo td = new TrayIconDemo();
            try {
                td.displayTray();
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }else {
            System.err.println("System tray not supported!");
        }
	}
}