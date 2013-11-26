package log121.lab4.app;

import log121.lab4.api.Gardien;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class CommandeZoom extends CommandeAbstraite {

    private final ModelePerspective modelePerspective;
    private int increment;
    private final Gardien gardien;

    public CommandeZoom(ModelePerspective modelePerspective)
    {
        this(modelePerspective, 0);
    }

    public CommandeZoom(ModelePerspective modelePerspective, int increment) {
        super("app.frame.menus.transform.zoom");
        gardien = new Gardien(modelePerspective);
        this.modelePerspective = modelePerspective;
        this.increment = increment;
    }

    @Override
    public void executer() {
        gardien.sauvegarder();
        modelePerspective.setZoom(modelePerspective.getZoom() + increment);
    }

    @Override
    public void annuler() {
        gardien.annuler();
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
    	Integer _increment = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entree le poucentage de l'incrementation"));
    	
    	if(_increment != null)
    		this.increment = _increment;
    }

}
