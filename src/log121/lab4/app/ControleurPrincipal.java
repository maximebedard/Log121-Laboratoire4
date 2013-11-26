package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.MenuAdapter;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private MenuPrincipal menuPrincipal;

    public ControleurPrincipal() {
        initVueModel();
        initComposantes();
        initListeners();
    }

    private void initListeners() {
    }

    private void initVueModel() {
        modeleImage = new ModeleImage();
        modelePerspective = new ModelePerspective();

        modeles.add(modeleImage);
        modeles.add(modelePerspective);

        GestionnaireCommandes comMananger = GestionnaireCommandes.getInstance();
        comMananger.ajouterGardien(new Gardien(modeleImage));
        comMananger.ajouterGardien(new Gardien(modelePerspective));


        vueZoom = new VueZoom();
        vueGlobale = new VueGlobale();
        vueTranslation = new VueTranslation();

        vues.add(vueZoom);
        vues.add(vueTranslation);
        vues.add(vueGlobale);

        for(Modele m : modeles)
            for(Vue v : vues)
                m.addObserver(v);
    }

    private void initComposantes() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(ResourceManager.getResource("app.frame.title"));
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(vueZoom);
        panel.add(vueTranslation);
        panel.add(vueGlobale);

        menuPrincipal = new MenuPrincipal(modeleImage, modelePerspective);

        frame.add(menuPrincipal, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(800, 400);
        frame.setResizable(false);
    }

    public static void main(String[] args)
    {
        new ControleurPrincipal();
    }
}
