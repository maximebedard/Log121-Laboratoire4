package log121.lab4.app;

import log121.lab4.api.Modele;
import log121.lab4.api.Vue;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
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
        vueTranslation.addMouseListener(new TranslationListener());
    }

    private void initVueModel() {
        modeleImage = new ModeleImage();
        modelePerspective = new ModelePerspective();

        modeles.add(modeleImage);
        modeles.add(modelePerspective);

        vueZoom = new VueZoom();
        vueGlobale = new VueGlobale();
        vueTranslation = new VueTranslation();

        vues.add(vueZoom);
        vues.add(vueGlobale);
        vues.add(vueTranslation);

        for (Modele m : modeles)
            for (Vue v : vues)
                m.addObserver(v);

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

    private class TranslationListener extends MouseInputAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            modelePerspective.setX(modelePerspective.getX() + e.getX());
            modelePerspective.setX(modelePerspective.getY() + e.getY());
        }
    }

}
