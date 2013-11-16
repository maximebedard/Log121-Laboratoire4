package log121.lab4.app;

import log121.lab4.api.Modele;
import log121.lab4.api.Vue;

import javax.swing.JFrame;


public class FenetrePrincipale extends JFrame {

    private static final long serialVersionUID = -547817680802874525L;

    public FenetrePrincipale() {


        Perspective perspective = new Perspective();
        Image image = new Image();
        ControleurPrincipal controleurPrincipal = new ControleurPrincipal(perspective, image);

        controleurPrincipal.ajouterVue(new VueGlobale());
        controleurPrincipal.ajouterVue(new VueZoom());
        controleurPrincipal.ajouterVue(new VueTranslation());
    }
}
