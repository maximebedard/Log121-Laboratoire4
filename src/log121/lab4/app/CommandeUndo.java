package log121.lab4.app;


import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class CommandeUndo extends CommandeAbstraite {


    public CommandeUndo() {
        super("app.frame.menus.edition.undo");
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
        return true;
    }
}
