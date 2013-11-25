package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.ICommande;

import javax.swing.*;

public class CommandeZoom extends CommandeAbstraite {

    private final ModelePerspective modelePerspective;
    private final int zoom;
    private final int increment;
    private final Gardien gardien;

    public CommandeZoom(ModelePerspective modelePerspective)
    {
        // TODO : Ajouter un input box pour receuillir les valeurs
        this(modelePerspective, 0);
    }

    public CommandeZoom(ModelePerspective modelePerspective, int increment) {
        super("app.frame.menus.transform.zoomin");
        gardien = new Gardien(modelePerspective);
        this.zoom = modelePerspective.getZoom();
        this.modelePerspective = modelePerspective;
        this.increment = increment;
    }

    @Override
    public void executer() {
        gardien.sauvegarder();
        modelePerspective.setZoom(zoom + increment);
    }

    @Override
    public void annuler() {
        gardien.annuler();
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
