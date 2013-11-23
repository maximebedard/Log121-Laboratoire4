package log121.lab4.app;


import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;

public class CommandeOuvrir implements ICommande {


    private final ModeleImage modele;
    private final String chemin;

    public CommandeOuvrir(ModeleImage modele, String chemin) {
        this.modele = modele;
        this.chemin = chemin;
    }

    @Override
    public void executer() {

        if(chemin.endsWith("lab4"))
            ouvrirEtat();
        else
            ouvrirImage();
    }

    private void ouvrirImage()
    {
        modele.setChemin(chemin);
    }

    private void ouvrirEtat()
    {
        try {
            Modele m = Modele.deserialiser(chemin);
            modele.restaurerMemento(m.creerMemento());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
