package log121.lab4.api;

import javax.swing.*;
import java.util.Observer;

public abstract class Vue extends JPanel implements Observer {

    protected Vue()
	{
        initComponents();
	}

	protected abstract void initComponents();

}
