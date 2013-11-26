package log121.lab4.app;

import log121.lab4.api.Gardien;

import java.awt.event.ActionEvent;

public class CommandeZoom extends CommandeAbstraite {

    private final ModelePerspective modelePerspective;
    private final int increment;

    public CommandeZoom(ModelePerspective modelePerspective)
    {
        this(modelePerspective, 0);
    }

    public CommandeZoom(ModelePerspective modelePerspective, int increment) {
        super("app.frame.menus.transform.zoom");
        this.modelePerspective = modelePerspective;
        this.increment = increment;
    }

    @Override
    public void executer() {
        modelePerspective.setZoom(modelePerspective.getZoom() + increment);
    }

    @Override
    public boolean annulable() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        promptZoom();
        if(increment == 0)
            return;

        super.actionPerformed(e);
    }

    private void promptZoom() {

    }

}
