package log121.lab4.app;


import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.ArrayList;

public class CommandeOuvrir extends CommandeAbstraite {

    private Modele modele;
    private final ArrayList<Vue> vues;
    private final String chemin;

    public CommandeOuvrir(Modele modele, ArrayList<Vue> vues)
    {
        // todo ajouter input box
        this(modele, vues, "");
    }

    public CommandeOuvrir(Modele modele, ArrayList<Vue> vues, String chemin) {
        super("app.frame.menus.file.load");
        this.modele = modele;
        this.vues = vues;
        this.chemin = chemin;
    }

    @Override
    public void executer() {
        try {
            modele = Modele.deserialiser(chemin);
            for(Vue v : vues)
                modele.addObserver(v);

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
