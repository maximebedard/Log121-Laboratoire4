package log121.lab4.app;

import log121.lab4.api.*;

import java.util.ArrayList;

public class CommandeSauvegarder implements ICommande {

    private final ArrayList<Modele> modeles;

    public CommandeSauvegarder(ArrayList<Modele> modeles) {
        this.modeles = modeles;
    }

    @Override
    public void executer() {
        // TODO : Implémenter la sérialisation
    }

    @Override
    public void defaire() {
        // TODO : Annuler la sauvegarde?
    }
}
