package log121.lab4.app;

import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CommandeSauvegarder implements ICommande {

    private final Modele modele;
    private final String chemin;

    public CommandeSauvegarder(Modele modele, String chemin) {
        this.modele = modele;
        this.chemin = chemin;
    }

    @Override
    public void executer() {

        try {
            FileOutputStream fileOut = new FileOutputStream(chemin);

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(modele);
            out.close();

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
