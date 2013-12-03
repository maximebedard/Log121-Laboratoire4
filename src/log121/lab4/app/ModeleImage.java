/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: ModeleImage.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ModeleImage extends Modele {

    private static final long serialVersionUID = -679409394432923243L;

    private static final String DEFAULT_CHEMIN = "";

    private transient BufferedImage image = null;

    private String chemin = "";

    @Override
    public void restaurerMemento(Memento m) {
        if (m == null)
            throw new NullPointerException();

        if (!(m.getEtat() instanceof ModeleImage))
            throw new IllegalArgumentException();

        ModeleImage i = (ModeleImage) m.getEtat();
        setChemin(i.getChemin());
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        if(this.chemin != null && this.chemin.equals(chemin))
            return;

        this.chemin = chemin;
        loadImage();
        setChanged();
        notifyObservers(chemin);
    }

    private void loadImage() {
        try {
            image = ImageIO.read(new File(getChemin()));
        } catch (Exception e) {
            image = null;
        }

    }

    @Override
    public void initDefaults() {
        setChemin(DEFAULT_CHEMIN);
    }
}
