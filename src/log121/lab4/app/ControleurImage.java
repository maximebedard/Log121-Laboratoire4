package log121.lab4.app;


import log121.lab4.api.*;

public class ControleurImage extends Controleur<Image> {

    private final VueGlobale vueGlobale;

    private final VueTranslation vueTranslation;

    private final VueZoom vueZoom;

    public ControleurImage(Image modele, VueGlobale vueGlobale, VueTranslation vueTranslation, VueZoom vueZoom) {
        super(modele);
        this.vueGlobale = vueGlobale;
        this.vueTranslation = vueTranslation;
        this.vueZoom = vueZoom;

        attacherEvenementsVueGlobale();
        attacherEvenementsVueZoom();
        attacherEvenementsVueTranslation();
    }

    private void attacherEvenementsVueGlobale()
    {
    }

    private void attacherEvenementsVueZoom()
    {
    }

    private void attacherEvenementsVueTranslation()
    {
    }

}
