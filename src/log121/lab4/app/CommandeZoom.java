package log121.lab4.app;

import log121.lab4.api.ICommande;

import javax.swing.*;

public class CommandeZoom implements ICommande {

    private final ModelePerspective modelePerspective;
    private final int zoom;
    private final int increment;

    public CommandeZoom(ModelePerspective modelePerspective, int increment) {
        this.zoom = modelePerspective.getZoom();
        this.modelePerspective = modelePerspective;
        this.increment = increment;
    }

    @Override
    public void executer() {
        modelePerspective.setZoom(zoom + increment);
    }

    @Override
    public void annuler() {
        modelePerspective.setZoom(zoom - increment);
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
