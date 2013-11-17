package log121.lab4.app;

import javax.swing.*;


public class FenetrePrincipale extends JFrame {

    private static final long serialVersionUID = -547817680802874525L;

    private final JDesktopPane desktopPane = new JDesktopPane();

    public FenetrePrincipale() {

        new ControleurImage(
                new Image(),
                new VueGlobale(),
                new VueTranslation(),
                new VueZoom()
        );

    }

    public static void main(String[] args)
    {
        new FenetrePrincipale();
    }
}
