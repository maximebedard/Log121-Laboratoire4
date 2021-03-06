/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: MenuPrincipal.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import log121.lab4.api.MenuAdapter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;

public class MenuPrincipal extends JMenuBar {

    private final ModeleImage modeleImage;
    private final ModelePerspective modelePerspective;


    private static final String MENU_AIDE_TITRE = "app.frame.menus.help.title",
            MENU_TRANSFORM_TITLE = "app.frame.menus.transform.title",
            MENU_EDITION_TITLE = "app.frame.menus.edition.title",
            MENU_FICHIER_TITLE = "app.frame.menus.file.title";

    private static final String MENU_EDITION_UNDO_TITLE = "app.frame.menus.edition.undo",
            MENU_EDITION_REDO_TITLE = "app.frame.menus.edition.redo";


    public MenuPrincipal(ModeleImage modeleImage, ModelePerspective modelePerspective) {
        this.modeleImage = modeleImage;
        this.modelePerspective = modelePerspective;
        creerMenuFichier();
        creerMenuEdition();
        creerMenuTransformation();
        creerMenuAide();
    }

    private void creerMenuAide() {
        JMenu aide = creerMenu(
                MENU_AIDE_TITRE,
                new JMenuItem[]{
                        new CommandeAide()
                });

        this.add(aide);
    }

    private void creerMenuTransformation() {
        JMenu transformation = creerMenu(
                MENU_TRANSFORM_TITLE,
                new JMenuItem[]{
                        new CommandeTranslation(modelePerspective),
                        new CommandeZoom(modelePerspective)
                });

        this.add(transformation);
    }

    private void creerMenuEdition() {

        final JMenuItem undo = new JMenuItem(ResourceManager.getResource(MENU_EDITION_UNDO_TITLE));
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));

        final JMenuItem redo = new JMenuItem(ResourceManager.getResource(MENU_EDITION_REDO_TITLE));
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        JMenu edition = creerMenu(
                MENU_EDITION_TITLE,
                new JMenuItem[]{
                        undo,
                        redo
                });

        edition.addMenuListener(new MenuAdapter() {
            @Override
            public void menuSelected(MenuEvent e) {
                GestionnaireCommandes manager = GestionnaireCommandes.getInstance();

                if (manager.annulerVide())
                    undo.setEnabled(false);
                else
                    undo.setEnabled(true);

                if (manager.refaireVide())
                    redo.setEnabled(false);
                else
                    redo.setEnabled(true);
            }
        });


        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    GestionnaireCommandes.getInstance().annuler();
                }
                catch (NoSuchElementException ex)
                {
                    // do nothing
                }
            }
        });

        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    GestionnaireCommandes.getInstance().refaire();
                }
                catch (NoSuchElementException ex)
                {
                    // do nothing
                }
            }
        });

        this.add(edition);
    }

    private void creerMenuFichier() {
        JMenu fichier = creerMenu(
                MENU_FICHIER_TITLE,
                new JMenuItem[]{
                        new CommandeOuvrir(modeleImage, modelePerspective),
                        new CommandeSauvegarder(modeleImage, modelePerspective),
                        new CommandeQuitter()
                });
        this.add(fichier);
    }


    private JMenu creerMenu(String resourceKey, JMenuItem[] menus) {
        JMenu menu = new JMenu(ResourceManager.getResource(resourceKey));
        for (JMenuItem key : menus) {
            menu.add(key);
        }
        return menu;
    }
}