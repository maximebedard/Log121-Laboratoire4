package log121.lab4.app;

import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandeSauvegarder extends CommandeAbstraite {

    private final Modele modele;
    private final String chemin;

    public CommandeSauvegarder(Modele modele)
    {
        // todo : ajouter input box
        this(modele, "");
    }

    public CommandeSauvegarder(Modele modele, String chemin) {
        super("app.frame.menus.file.save");
        this.modele = modele;
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        try {
            Modele.serialiser(modele, chemin);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
