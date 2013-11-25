package log121.lab4.app;


import log121.lab4.api.ICommande;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class CommandeQuitter extends CommandeAbstraite {

    public CommandeQuitter() {
        super("app.frame.menus.file.exit");
    }

    @Override
    public void executer() {
        System.exit(0);
    }

    @Override
    public void annuler() {
        throw new NotImplementedException();
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
