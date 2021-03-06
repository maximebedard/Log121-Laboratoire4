/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: VueZoom.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueZoom extends Vue {

    private static final long serialVersionUID = 8550598435588018968L;

    private int x = 0;
    private int y = 0;
    private int zoom = 100;

    private BufferedImage image;

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof ModeleImage) {
            image = ((ModeleImage) o).getImage();
        }

        if (o instanceof ModelePerspective) {
            ModelePerspective p = (ModelePerspective) o;
            x = p.getX();
            y = p.getY();
            zoom = p.getZoom();
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (image == null) return;
        g.drawImage(image, x, y, image.getWidth() * zoom / 100, image.getHeight() * zoom / 100 , null);
        drawString(String.format("Zoom : %d", zoom), g);
    }
}
