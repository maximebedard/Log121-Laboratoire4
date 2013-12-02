package log121.lab4.app;

import log121.lab4.api.IConstantes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CommandeZoom extends Commande implements MouseWheelListener {

    private final ModelePerspective modelePerspective;
    private int increment;
    private final int INCREMENT_SIZE = 5;


    public CommandeZoom(ModelePerspective modelePerspective) {
        this(modelePerspective, 0);
    }

    public CommandeZoom(ModelePerspective modelePerspective, int increment) {
        super("app.frame.menus.transform.zoom", KeyEvent.VK_R);
        this.modelePerspective = modelePerspective;
        this.increment = increment;
    }

    @Override
    public void executer() {
        modelePerspective.incrementZoom(increment);
    }

    @Override
    public boolean annulable() {
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        promptZoom();
        if (increment == 0)
            return;

        super.actionPerformed(e);
    }

    private void promptZoom() {
        try
        {
            increment = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entree le poucentage de l'incrementation"));
        }
        catch (NumberFormatException ex)
        {
            increment = 0;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        double rotation = e.getPreciseWheelRotation();
        if (rotation < 0)
            increment = -1 * INCREMENT_SIZE;
        else
            increment = INCREMENT_SIZE;

        GestionnaireCommandes.getInstance().executer(this);
    }

}
