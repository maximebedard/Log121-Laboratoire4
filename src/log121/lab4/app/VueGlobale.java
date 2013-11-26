package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueGlobale extends Vue {

	private static final long serialVersionUID = -7558465286428238937L;

    Image image;

    @Override
	public void initComponents() {
        setBounds(0,0,100,100);
        setOpaque(false);
	}

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ModeleImage)
        {
            image = ((ModeleImage)o).getImage();
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, 100, 100, null);
    }
}
