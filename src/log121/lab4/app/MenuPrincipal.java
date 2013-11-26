package log121.lab4.app;

import log121.lab4.api.MenuAdapter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JMenuBar
{

    private final ModeleImage modeleImage;
    private final ModelePerspective modelePerspective;
    private JMenu fichier;

    private JMenu edition;

    private JMenu transformation;

    private JMenu aide;



    public MenuPrincipal(ModeleImage modeleImage, ModelePerspective modelePerspective) {
        this.modeleImage = modeleImage;
        this.modelePerspective = modelePerspective;
        creerMenuFichier();
        creerMenuEdition();
        creerMenuTransformation();
        creerMenuAide();
    }

    private void creerMenuAide() {
        aide = creerMenu(
                "app.frame.menus.help.title",
                new JMenuItem[]{
                        new CommandeAide()
                });

        this.add(aide);
    }

    private void creerMenuTransformation() {
        transformation = creerMenu(
                "app.frame.menus.transform.title",
                new JMenuItem[]{
                        new CommandeTranslation(modelePerspective),
                        new CommandeZoom(modelePerspective)
                });

        this.add(transformation);
    }

    private void creerMenuEdition() {

        final JMenuItem undo = new JMenuItem(ResourceManager.getResource("app.frame.menus.edition.undo"));
        final JMenuItem redo = new JMenuItem(ResourceManager.getResource("app.frame.menus.edition.redo"));
        edition = creerMenu(
                "app.frame.menus.edition.title",
                new JMenuItem[]{
                        undo,
                        redo
                });

        edition.addMenuListener(new MenuAdapter() {
            @Override
            public void menuSelected(MenuEvent e) {
                GestionnaireCommandes manager = GestionnaireCommandes.getInstance();

                if(manager.annulerVide())
                    undo.setEnabled(false);
                else
                    undo.setEnabled(true);

                if(manager.refaireVide())
                    redo.setEnabled(false);
                else
                    redo.setEnabled(true);
            }
        });


        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionnaireCommandes.getInstance().annuler();
            }
        });

        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionnaireCommandes.getInstance().refaire();
            }
        });

        this.add(edition);
    }

    private void creerMenuFichier() {
        fichier = creerMenu(
                "app.frame.menus.file.title",
                new JMenuItem[] {
                        new CommandeOuvrir(modeleImage, modelePerspective),
                        new CommandeSauvegarder(modeleImage, modelePerspective),
                        new CommandeQuitter()
                });
        this.add(fichier);
    }


    private JMenu creerMenu(String resourceKey, JMenuItem[] menus) {
        JMenu menu = new JMenu(ResourceManager.getResource(resourceKey));
        for (JMenuItem key : menus)
        {
            menu.add(key);
        }
        return menu;
    }
}