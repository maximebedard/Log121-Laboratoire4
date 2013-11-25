package log121.lab4.app;


import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

public class CommandeUndo implements ICommande {



    @Override
    public void executer() {
        GestionnaireCommandes.getInstance().annuler();
    }

    @Override
    public void annuler() {
        GestionnaireCommandes.getInstance().refaire();
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
