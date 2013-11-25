package log121.lab4.app;


import log121.lab4.api.ICommande;

import javax.swing.*;

public class CommandeRedo extends JMenu implements ICommande {

    @Override
    public void executer() {
    }

    @Override
    public void annuler() {
    }

    @Override
    public boolean annulable() {
        return false;
    }
}
