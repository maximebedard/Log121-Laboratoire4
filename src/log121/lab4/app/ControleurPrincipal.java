package log121.lab4.app;

import log121.lab4.api.Gardien;
import log121.lab4.api.Modele;
import log121.lab4.api.Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * User: maximebedard
 * Date: 11/21/2013
 * Time: 2:53 PM
 */
public class ControleurPrincipal extends JFrame {

    private VueZoom vueZoom;
    private VueGlobale vueGlobale;
    private VueTranslation vueTranslation;

    private ModeleImage modeleImage;
    private ModelePerspective modelePerspective;

    private final ArrayList<Vue> vues = new ArrayList<Vue>();
    private final ArrayList<Modele> modeles = new ArrayList<Modele>();

    public ControleurPrincipal() {
        initVueModel();
        initComposantes();
        initListeners();
    }

    private void initListeners() {
        CommandeTranslation commandTranslation = new CommandeTranslation(modelePerspective);
        vueTranslation.addMouseListener(commandTranslation);
        vueTranslation.addMouseMotionListener(commandTranslation);

        vueZoom.addMouseWheelListener(new CommandeZoom(modelePerspective));
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

        for (Modele m : modeles)
            for (Vue v : vues)
                m.addObserver(v);
    }

    private void initComposantes() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(ResourceManager.getResource("app.frame.title"));
        setLayout(new BorderLayout());
        setSize(new Dimension(800, 600));

        JPanel container = new JPanel();
        JPanel bottomPanel = new JPanel();

        container.setLayout(new GridLayout(2, 1));
        bottomPanel.setLayout(new GridLayout(1, 2));

        bottomPanel.add(vueTranslation);
        bottomPanel.add(vueZoom);
        container.add(vueGlobale);
        container.add(bottomPanel);

        MenuPrincipal menuPrincipal = new MenuPrincipal(modeleImage, modelePerspective);

        add(menuPrincipal, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);
        setResizable(false);
    }


    public static void main(String[] args) {
        new ControleurPrincipal();
    }

}
