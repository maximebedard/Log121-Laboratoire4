package log121.lab4.app;

import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.ArrayList;

public class CommandeNouveau implements ICommande {

    private final ArrayList<Modele> modeles;
    private final ArrayList<Vue> vues;
    private final Modele nouveauModele;


    public CommandeNouveau(ArrayList<Modele> modeles, ModeleType type, ArrayList<Vue> vues)
    {
        this.modeles = modeles;
        this.vues = vues;
        nouveauModele = ModeleFactory.creerModele(type);
    }

    @Override
    public void executer() {
        modeles.add(nouveauModele);
        for (Vue v : vues)
            nouveauModele.addObserver(v);
    }

    @Override
    public void annuler() {
        throw new NotImplementedException();
    }

    @Override
    public boolean annulable() {
        return false;
    }

    public Modele getNouveauModele()
    {
        return nouveauModele;
    }

}
