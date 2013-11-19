package log121.lab4.app;

import log121.lab4.api.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CommandeSauvegarder implements ICommande {

    private final ArrayList<Modele> modeles;
    private final String chemin;

    public CommandeSauvegarder(ArrayList<Modele> modeles, String chemin) {
        this.modeles = modeles;
        this.chemin = chemin;
    }

    @Override
    public void executer() {

        try {
            FileOutputStream fileOut = new FileOutputStream(chemin);

            for (Modele m : modeles)
            {
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(m);
                out.close();
            }

            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
