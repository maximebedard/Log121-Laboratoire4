package log121.lab4.app;


import java.awt.event.KeyEvent;

public class CommandeQuitter extends Commande {

    public CommandeQuitter() {
        super("app.frame.menus.file.exit", KeyEvent.VK_Q);
    }

    @Override
    public void executer() {
        System.exit(0);
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
