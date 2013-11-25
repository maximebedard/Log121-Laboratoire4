package log121.lab4.app;


import log121.lab4.api.ICommande;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class CommandeQuitter extends JMenuItem implements ICommande {

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
