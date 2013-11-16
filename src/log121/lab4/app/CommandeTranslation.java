package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.ICloneable;
import log121.lab4.api.ICommande;

public class CommandeTranslation implements ICommande {

    private final Gardien<Perspective> gardien;

    private final Perspective perspective;

    private final int dx;

    private final int dy;

    public CommandeTranslation(Perspective perspective, int dx, int dy)
    {
        this.gardien = new Gardien<Perspective>(perspective);
        this.perspective = perspective;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void executer() {
        gardien.sauvegarder();
        perspective.translater(dx, dy);
    }

    @Override
    public void defaire() {
        gardien.annuler();
    }
}
