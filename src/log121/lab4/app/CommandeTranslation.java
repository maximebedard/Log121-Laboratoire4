package log121.lab4.app;

import log121.lab4.api.Gardien;

public class CommandeTranslation extends CommandeAbstraite {

    private final ModelePerspective modelePerspective;

    private final int dx;

    private final int dy;

    public CommandeTranslation(ModelePerspective modelePerspective)
    {
        // TODO : Ajouter input box ici
        this(modelePerspective, 0,0);
    }

    public CommandeTranslation(ModelePerspective modelePerspective, int dx, int dy)
    {
        super("app.frame.menus.transform.translate");
        this.modelePerspective = modelePerspective;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void executer() {
        modelePerspective.translater(dx, dy);
    }

    @Override
    public boolean annulable() {
        return true;
    }
}
