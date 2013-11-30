package log121.lab4.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import log121.lab4.api.IConstantes;

public class CommandeZoom extends CommandeAbstraite implements MouseWheelListener{

    private final ModelePerspective modelePerspective;
    private int increment;

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
        modelePerspective.setZoom((int)(IConstantes.GRANDEUR_IMAGE * ((double)increment/100)));
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

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e == null) return;
		
		if(e.getPreciseWheelRotation() == -1)
			modelePerspective.setZoom(modelePerspective.getZoom()-10);
		else if(e.getPreciseWheelRotation() == 1)
			modelePerspective.setZoom(modelePerspective.getZoom()+10);
	}

}
