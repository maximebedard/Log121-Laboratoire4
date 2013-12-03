/******************************************************
 Cours:  LOG121
 Projet: Laboratoire 4
 Nom du fichier: Vue.java
 Date créé: 2013-12-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Maxime Bédard
2013-12-03 Version initiale
 *******************************************************/

package log121.lab4.api;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Observer;

public abstract class Vue extends JPanel implements Observer {

    private static Font DEFAULT_FONT = new Font("Serif", Font.PLAIN, 32);

    protected void drawString(String str, Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setFont(DEFAULT_FONT);

        FontMetrics fontMetrics = graphics.getFontMetrics(DEFAULT_FONT);
        Rectangle2D rect = fontMetrics.getStringBounds(str, graphics);
        graphics.drawString(str, (int) (this.getWidth() - rect.getWidth()), this.getHeight() - fontMetrics.getAscent());

    }


}
