package log121.lab4.app;

import log121.lab4.api.ICommande;

public class CommandeZoom implements ICommande {

    private final ModelePerspective modelePerspective;
    private final int zoom;

    public CommandeZoom(ModelePerspective modelePerspective, int zoom) {
        this.zoom = zoom;
        this.modelePerspective = modelePerspective;
    }

    @Override
    public void executer() {
        modelePerspective.setZoom(zoom);
    }

    @Override
    public void annuler() {
        modelePerspective.setZoom(-1*zoom);
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
