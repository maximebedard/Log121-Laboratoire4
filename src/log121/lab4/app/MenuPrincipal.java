package log121.lab4.app;

import javax.swing.*;

public class MenuPrincipal extends JMenuBar {

    private JMenu fichier;

    private JMenu edition;

    private JMenu transformation;

    private JMenu aide;

    public JMenu getFichier()
    {
        return fichier;
    }

    public JMenu getEdition(){
        return edition;
    }

    public JMenu getTransformation(){
        return transformation;
    }

    public JMenu getAide(){
        return aide;
    }

    public MenuPrincipal() {
        creerMenuFichier();
        creerMenuEdition();
        creerMenuTransformation();
        creerMenuAide();
    }

    private void creerMenuAide() {
        aide = creerMenu(
                "app.frame.menus.help.title",
                new String[]{
                        "app.frame.menus.help.about"
                });

        this.add(aide);
    }

    private void creerMenuTransformation() {
        transformation = creerMenu(
                "app.frame.menus.transform.title",
                new String[]{
                        "app.frame.menus.transform.translate",
                        "app.frame.menus.transform.zoomin",
                        "app.frame.menus.transform.zoomout"
                });

        this.add(transformation);
    }

    private void creerMenuEdition() {

        edition = creerMenu(
                "app.frame.menus.edition.title",
                new String[]{
                        "app.frame.menus.edition.undo",
                        "app.frame.menus.edition.redo"
                });

        this.add(edition);
    }

    private void creerMenuFichier() {
        fichier = creerMenu(
                "app.frame.menus.file.title",
                new String[]{
                        "app.frame.menus.file.save",
                        "app.frame.menus.file.load",
                        "app.frame.menus.file.exit"
                });
        this.add(fichier);
    }



    private static JMenu creerMenu(String resourceKey, String[] itemKeys) {
        JMenu menu = new JMenu(ResourceManager.getResource(resourceKey));
        for (String key : itemKeys)
            menu.add(new JMenuItemCommande(ResourceManager.getResource(key)));
        return menu;
    }


}
