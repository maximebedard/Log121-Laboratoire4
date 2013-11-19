package log121.lab4.app;

import log121.lab4.api.Controleur;
import log121.lab4.app.Image;
import log121.lab4.app.VueTranslation;

import java.awt.event.ActionEvent;

public class ControleurImageTranslation extends Controleur<Image, VueTranslation> {

    public ControleurImageTranslation(Image modele, VueTranslation vue) {
        super(modele, vue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
