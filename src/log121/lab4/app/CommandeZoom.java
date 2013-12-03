/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: CommandeZoom.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CommandeZoom extends Commande implements MouseWheelListener {

    private final ModelePerspective modelePerspective;

    private int increment;

    public CommandeZoom(ModelePerspective modelePerspective) {
        super("app.frame.menus.transform.zoom", KeyEvent.VK_R);
        this.modelePerspective = modelePerspective;
        this.increment = 0;
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
        super.actionPerformed(e);
    }

    /**
     * Affiche un dialog pour entrer l'incrément
     */
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
        int INCREMENT_SIZE = 5;
        if (rotation < 0)
            increment = -1 * INCREMENT_SIZE;
        else
            increment = INCREMENT_SIZE;

        GestionnaireCommandes.getInstance().executer(this);
    }

}
