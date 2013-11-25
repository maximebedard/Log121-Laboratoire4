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

        vueZoom = new VueZoom();
        vueGlobale = new VueGlobale();
        vueTranslation = new VueTranslation();

        vues.add(vueZoom);
        vues.add(vueGlobale);
        vues.add(vueTranslation);

        for(Modele m : modeles)
            for(Vue v : vues)
                m.addObserver(v);
    }

    private void initComposantes() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Laboratoire 4");
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(vueGlobale);
        panel.add(vueZoom);
        panel.add(vueTranslation);



        menuPrincipal = new MenuPrincipal();


        frame.add(menuPrincipal, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
    }




    private class MenuPrincipal extends JMenuBar
    {

        private JMenu fichier;

        private JMenu edition;

        private JMenu transformation;

        private JMenu aide;


        public MenuPrincipal() {
            creerMenuFichier();
            creerMenuEdition();
            creerMenuTransformation();
            creerMenuAide();
        }

        private void creerMenuAide() {
            aide = creerMenu(
                    "app.frame.menus.help.title",
                    new CommandeAbstraite[]{
                        new CommandeAide()
                    });

            this.add(aide);
        }

        private void creerMenuTransformation() {
            transformation = creerMenu(
                    "app.frame.menus.transform.title",
                    new CommandeAbstraite[]{
                            new CommandeTranslation(modelePerspective),
                            new CommandeZoom(modelePerspective)
                    });

            this.add(transformation);
        }

        private void creerMenuEdition() {

            edition = creerMenu(
                    "app.frame.menus.edition.title",
                    new CommandeAbstraite[]{
                            new CommandeUndo(),
                            new CommandeRedo()
                    });

            this.add(edition);
        }

        private void creerMenuFichier() {
            fichier = creerMenu(
                    "app.frame.menus.file.title",
                    new CommandeAbstraite[] {
                        new CommandeOuvrir(modeleImage, vues),
                        new CommandeSauvegarder(modeleImage),
                        new CommandeQuitter()
                    });
            this.add(fichier);
        }


        private JMenu creerMenu(String resourceKey, CommandeAbstraite[] commandeAbstraites) {
            JMenu menu = new JMenu(ResourceManager.getResource(resourceKey));
            for (CommandeAbstraite key : commandeAbstraites)
            {
                menu.add(key);
            }
            return menu;
        }
    }


    public static void main(String[] args)
    {
        new ControleurPrincipal();
    }
}
