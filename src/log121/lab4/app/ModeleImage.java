package log121.lab4.app;

import log121.lab4.api.Memento;
import log121.lab4.api.Modele;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ModeleImage extends Modele {

    private static final long serialVersionUID = -679409394432923243L;

    private transient BufferedImage image;

    private String chemin;

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
        this.chemin = chemin;
        setChanged();
        notifyObservers(chemin);
    }


    public void setImage(BufferedImage image) {
        this.image = image;
        setChanged();
        notifyObservers(image);
    }
}
