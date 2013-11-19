package log121.lab4.api;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class Controleur<M extends Modele, V extends Vue> implements ActionListener {

    private final M modele;

    private final V vue;

    protected Controleur(M modele, V vue) {
        this.modele = modele;
        this.vue = vue;
    }

    public V getVue() {
        return vue;
    }

    public M getModele() {
        return modele;
    }
}
