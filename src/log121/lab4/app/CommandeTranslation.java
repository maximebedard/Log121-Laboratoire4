package log121.lab4.app;

import log121.lab4.api.ICommande;

public class CommandeTranslation implements ICommande {

    private final ModelePerspective modelePerspective;

    private final int dx;

    private final int dy;

    public CommandeTranslation(ModelePerspective modelePerspective, int dx, int dy)
    {
        this.modelePerspective = modelePerspective;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void executer() {
        modelePerspective.translater(dx, dy);
    }

    @Override
    public void annuler() {
        modelePerspective.translater(-1 * dx, -1 * dy);
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
