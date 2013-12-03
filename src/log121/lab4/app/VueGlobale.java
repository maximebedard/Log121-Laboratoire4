/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: VueGlobale.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.app;

import log121.lab4.api.Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueGlobale extends Vue {

    private static final long serialVersionUID = -7558465286428238937L;

    private Image image = null;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ModeleImage) {
            ModeleImage modeleImage = ((ModeleImage) o);
            BufferedImage img = modeleImage.getImage();

            image = scaleImage(this, img);
        }

        repaint();
    }

    /**
     * Mise à lécelle de l'image
     * @param comp composante ou sera dessiné l'image
     * @param image image à haute/faible résolution
     * @return l'image mise à l'échelle
     */
    private static Image scaleImage(JComponent comp, BufferedImage image) {

        if(image == null)
            return null;

        double scaleFactor = Math.min(1d, getScaleFactorToFit(new Dimension(image.getWidth(), image.getHeight()), comp.getSize()));

        int scaleWidth = (int) Math.round(image.getWidth() * scaleFactor);
        int scaleHeight = (int) Math.round(image.getHeight() * scaleFactor);

        return image.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);

    }

    /**
     * Retourne un facteur utilisé pour mettre à l'echelle une image
     * Source : http://stackoverflow.com/questions/11959758/java-maintaining-aspect-ratio-of-jpanel-background-image/11959928#11959928
     *
     * @param masterSize
     * @param targetSize
     * @return facteur de mise à l'échelle
     */
    private static double getScaleFactor(int masterSize, int targetSize) {

        return masterSize > targetSize ? (double) targetSize / (double) masterSize :
                (double) targetSize / (double) masterSize;

    }

    /**
     * Retourne un facteur utilisé pour mettre à l'échelle une image afin que celle-ci fit dans le JPanel
     * Source : http://stackoverflow.com/questions/11959758/java-maintaining-aspect-ratio-of-jpanel-background-image/11959928#11959928
     *
     * @param original
     * @param toFit
     * @return facteur de mise à l'échelle qui laisse des espaces
     */
    private static double getScaleFactorToFit(Dimension original, Dimension toFit) {

        double dScale = 1d;

        if (original != null && toFit != null) {

            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);

            dScale = Math.min(dScaleHeight, dScaleWidth);

        }

        return dScale;

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (image == null) return;

        int width = getWidth() - 1;
        int height = getHeight() - 1;

        int x = (width - image.getWidth(this)) / 2;
        int y = (height - image.getHeight(this)) / 2;

        g.drawImage(image, x, y, this);

    }
}
