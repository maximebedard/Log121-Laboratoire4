package log121.lab4.app;

import log121.lab4.api.Vue;

import java.awt.*;
import java.util.Observable;

public class VueZoom extends Vue {

	private static final long serialVersionUID = 8550598435588018968L;

    @Override
	public void initComponents() {
        setBackground(Color.ORANGE);
        setPreferredSize(new Dimension(400, 400));
	}

    @Override
    public void update(Observable o, Object arg) {
    }


}
