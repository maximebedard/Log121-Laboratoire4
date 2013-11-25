package log121.lab4.app;

import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * User: maximebedard
 * Date: 11/21/2013
 * Time: 2:53 PM
 */
public class ControleurPrincipal {

    private VueZoom vueZoom;
    private VueGlobale vueGlobale;
    private VueTranslation vueTranslation;

    private ModeleImage modeleImage;
    private ModelePerspective modelePerspective;

    private ArrayList<Vue> vues = new ArrayList<Vue>();
    private ArrayList<Modele> modeles = new ArrayList<Modele>();

    private JFrame frame;

    public ControleurPrincipal() {
        initVueModel();
        initComposantes();
        initListeners();
    }

    private void initListeners() {
    }

    private void initVueModel() {
        vueZoom = new VueZoom();
        vueGlobale = new VueGlobale();
        vueTranslation = new VueTranslation();

        vues.add(vueZoom);
        vues.add(vueGlobale);
        vues.add(vueTranslation);
    }

    private void initComposantes() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Laboratoire 4");
        frame.setLayout(new FlowLayout());

        frame.add(vueGlobale);
        frame.add(vueZoom);
        frame.add(vueTranslation);
        frame.pack();

    }

    private class TranslationListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class OuvrirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class SauvegarderListener implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class ZoomListener implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            GestionnaireCommandes.getInstance().executer(new CommandeZoom(modelePerspective, e.getUnitsToScroll()));
        }
    }

    public static void main(String[] args)
    {
        new ControleurPrincipal();
    }
}
