package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueGlobale extends Vue {

    private static final long serialVersionUID = -7558465286428238937L;

    private Image image;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ModeleImage) {
            scaleImage(((ModeleImage) o).getImage());
            repaint();
        }
    }

    private void scaleImage(BufferedImage image) {

        if(image == null)
            return;

        double scaleFactor = Math.min(1d, getScaleFactorToFit(new Dimension(image.getWidth(), image.getHeight()), getSize()));

        int scaleWidth = (int) Math.round(image.getWidth() * scaleFactor);
        int scaleHeight = (int) Math.round(image.getHeight() * scaleFactor);

        Image scaled = image.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);

        int width = getWidth() - 1;
        int height = getHeight() - 1;

        int x = (width - scaled.getWidth(this)) / 2;
        int y = (height - scaled.getHeight(this)) / 2;

        this.image = scaled;

    }

    /**
     * Retourne un facteur utilisé pour mettre à l'echelle une image
     * Source : http://stackoverflow.com/questions/11959758/java-maintaining-aspect-ratio-of-jpanel-background-image/11959928#11959928
     *
     * @param masterSize
     * @param targetSize
     * @return facteur de mise à l'échelle
     */
    private double getScaleFactor(int masterSize, int targetSize) {

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
    private double getScaleFactorToFit(Dimension original, Dimension toFit) {

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
