package log121.lab4.app;

import javax.swing.*;


public class FenetrePrincipale extends JFrame {

    private static final long serialVersionUID = -547817680802874525L;

    private final JDesktopPane desktopPane = new JDesktopPane();

    public FenetrePrincipale() {

        Image image = new Image();

        VueTranslation vueTranslation = new VueTranslation();
        VueGlobale vueGlobale = new VueGlobale();
        VueZoom vueZoom = new VueZoom();

        new ControleurImageGlobale(image, vueGlobale);
        new ControleurImageTranslation(image, vueTranslation);
        new ControleurImageZoom(image, vueZoom);

    }

    public static void main(String[] args)
    {
        new FenetrePrincipale();
    }
}
