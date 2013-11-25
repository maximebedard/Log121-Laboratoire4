package log121.lab4.app;


import log121.lab4.api.ICommande;

import javax.swing.*;

public class CommandeRedo extends CommandeAbstraite {

    public CommandeRedo() {
        super("app.frame.menus.edition.redo");
    }

    @Override
    public void executer() {
        // todo
    }

    @Override
    public void annuler() {
        // todo
    }

    @Override
    public boolean annulable() {
        // todo
        return false;
    }
}
