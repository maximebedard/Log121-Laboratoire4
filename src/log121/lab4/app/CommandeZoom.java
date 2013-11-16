package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.ICloneable;
import log121.lab4.api.ICommande;
import log121.lab4.api.IOriginateur;

public class CommandeZoom implements ICommande {

    private final Gardien<Perspective> gardien;
    private final Perspective perspective;
    private final int zoom;

    public CommandeZoom(Perspective perspective, int zoom) {
        this.gardien = new Gardien<Perspective>(perspective);
        this.zoom = zoom;
        this.perspective = perspective;
    }

    @Override
    public void executer() {
        gardien.sauvegarder();
        perspective.setZoom(zoom);
    }

    @Override
    public void defaire() {
        gardien.annuler();
    }
}
