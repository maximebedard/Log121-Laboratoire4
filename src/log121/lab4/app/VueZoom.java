package log121.lab4.app;

import log121.lab4.api.IConstantes;
import log121.lab4.api.Vue;

import java.awt.*;
import java.util.Observable;

public class VueZoom extends Vue{

	private static final long serialVersionUID = 8550598435588018968L;

    private int x, y, zoom;

    private Image image;

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof ModeleImage)
        {
            image = ((ModeleImage)o).getImage();
            zoom = IConstantes.GRANDEUR_IMAGE;
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

        if(image == null) return;
        g.drawImage(image, x, y, zoom, zoom, null);
        drawString(String.format("Zoom : %d", zoom),g);
    }
}
