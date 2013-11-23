package log121.lab4.app;

import log121.lab4.api.Vue;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

public class VueTranslation extends Vue {

	private static final long serialVersionUID = 5404684093209799162L;

	@Override
	public void initComponents() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.YELLOW);
	}


    @Override
    public void update(Observable o, Object arg) {
    }
}
