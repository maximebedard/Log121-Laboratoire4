package log121.lab4.app;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class CommandeAide extends Commande {
    public CommandeAide() {
        super("app.frame.menus.help.about", KeyEvent.VK_H);
    }

    @Override
    public void executer() {
        JOptionPane.showMessageDialog(null, ResourceManager.getResource("app.frame.dialog.about"));
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
