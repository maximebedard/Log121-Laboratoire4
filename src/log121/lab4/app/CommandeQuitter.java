package log121.lab4.app;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandeQuitter extends CommandeAbstraite {

    public CommandeQuitter() {
        super("app.frame.menus.file.exit");
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
