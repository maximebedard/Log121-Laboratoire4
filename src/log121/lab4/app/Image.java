package log121.lab4.app;

import log121.lab4.api.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends Modele {

    public Image()
    {
        this.attacher(new IObserveur<AttrModifieEvenement>() {
            @Override
            public void update(AttrModifieEvenement event) {
                if(event.getAttribut().equals(CHEMIN_ATTR))
                    loadImage((String)event.getNouvelleValeur());
            }
        });
    }

	private static final long serialVersionUID = -679409394432923243L;

    public final static String CHEMIN_ATTR = "Chemin";

    private BufferedImage image;

    private String chemin;

    private Perspective perspective;

    private void loadImage(String chemin)
    {
        try {
            image = ImageIO.read(new File(chemin));
        } catch (IOException e) {
            image = null;
        }
    }

	@Override
	public void restaurerMemento(Memento m) {
        if(m == null)
            throw new NullPointerException();

        if(!(m.getEtat() instanceof Image))
            throw new IllegalArgumentException();

        Image i = (Image)m.getEtat();
        setChemin(i.getChemin());

	}


    public BufferedImage getImage() {
        return image;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        String oldChemin = this.chemin;
        this.chemin = chemin;
        lanceAttributEvenement("Chemin", oldChemin, chemin);
    }

    public Perspective getPerspective() {
        return perspective;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }
}
