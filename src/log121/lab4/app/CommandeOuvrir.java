package log121.lab4.app;


import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.ArrayList;

public class CommandeOuvrir extends CommandeNouveau {

    private final String chemin;

    public CommandeOuvrir(ArrayList<Modele> modeles, ModeleType type, ArrayList<Vue> vues, String chemin) {
        super(modeles, type, vues);
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        super.executer();
        try {
            Modele m = Modele.deserialiser(chemin);
            getNouveauModele().restaurerMemento(m.creerMemento());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
