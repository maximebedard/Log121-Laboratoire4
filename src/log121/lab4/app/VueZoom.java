package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueZoom extends Vue {

	private static final long serialVersionUID = 8550598435588018968L;

    private int x, y, zoom;

    private Image image;


    @Override
	public void initComponents() {
        setMinimumSize(new Dimension(400, 800));
        setBackground(Color.ORANGE);
	}

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof ModeleImage)
        {
            image = ((ModeleImage)o).getImage();
        }

        if(o instanceof ModelePerspective)
        {
            ModelePerspective p = (ModelePerspective)o;
            x = p.getX();
            y = p.getY();
            zoom = p.getZoom();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, x, y, null);
    }
}
