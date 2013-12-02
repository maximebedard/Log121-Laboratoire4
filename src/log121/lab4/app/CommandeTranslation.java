package log121.lab4.app;

import javax.swing.*;
import java.awt.event.*;

public class CommandeTranslation extends Commande implements MouseMotionListener, MouseListener {

    private final ModelePerspective modelePerspective;

    private int dx;
    private int dy;

    private int x0;
    private int y0;

    private int x_before;
    private int y_before;

    public CommandeTranslation(ModelePerspective modelePerspective) {
        this(modelePerspective, 0, 0);
    }

    public CommandeTranslation(ModelePerspective modelePerspective, int dx, int dy) {
        super("app.frame.menus.transform.translate", KeyEvent.VK_T);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        commandeTranslation();
        if(dx == 0 && dy == 0)
            return;

        super.actionPerformed(e);
    }

    private void commandeTranslation() {

        try
        {
            dx = Integer.parseInt(JOptionPane.showInputDialog("Veuillez inserer la coordonnee de x:"));
        }
        catch (NumberFormatException ex)
        {
            dx = 0;
        }

        try
        {
            dy = Integer.parseInt(JOptionPane.showInputDialog("Veuillez inserer la coordonnee de y:"));
        }
        catch (NumberFormatException ex)
        {
            dy = 0;
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        modelePerspective.setX(x_before + evt.getX() - x0);
        modelePerspective.setY(y_before + evt.getY() - y0);
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        x_before = modelePerspective.getX();
        y_before = modelePerspective.getY();
        x0 = evt.getX();
        y0 = evt.getY();
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        modelePerspective.setX(x_before);
        modelePerspective.setY(y_before);

        dx = evt.getX() - x0;
        dy = evt.getY() - y0;

        GestionnaireCommandes.getInstance().executer(this);
    }
}
