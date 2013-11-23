package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class VueGlobale extends Vue {

	private static final long serialVersionUID = -7558465286428238937L;

    @Override
	public void initComponents() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.blue);
	}



    @Override
    public void update(Observable o, Object arg) {
    }

}
