package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

public class VueTranslation extends Vue{

    private static final long serialVersionUID = 5404684093209799162L;

    Image image;
    int x, y;


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ModeleImage) {
            image = ((ModeleImage) o).getImage();
        }

        if (o instanceof ModelePerspective) {
            ModelePerspective p = ((ModelePerspective) o);
            x = p.getX();
            y = p.getY();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(image == null) return;

        g.drawImage(image, x, y, null);
        drawString(String.format("(%d, %d)", x, y), g);
    }
}
