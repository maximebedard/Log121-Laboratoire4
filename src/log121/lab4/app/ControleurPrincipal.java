package log121.lab4.app;


import log121.lab4.api.*;

import java.util.ArrayList;

public class ControleurPrincipal implements IObserveur<AttrModifieEvenement> {

    private final Perspective perspective;

    private final Image image;

    private final ArrayList<Vue> vues = new ArrayList<Vue>();

    public ControleurPrincipal(Perspective perspective, Image image) {
        this.perspective = perspective;
        this.image = image;
    }

    public void ajouterVue(Vue v)
    {
        vues.add(v);
    }

    public void enleverVue(Vue v)
    {
        vues.remove(v);
    }

    @Override
    public void update(AttrModifieEvenement event) {
        for(Vue v : vues)
            v.update(event);
    }
}
