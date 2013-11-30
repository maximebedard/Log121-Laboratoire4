package log121.lab4.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CommandeTranslation extends CommandeAbstraite implements MouseMotionListener, MouseListener{

    private final ModelePerspective modelePerspective;

    private int dx;

    private int dy;
    private int x_before;
    private int y_before;
   

    public CommandeTranslation(ModelePerspective modelePerspective)
    {       	
    	this(modelePerspective,0,0);    	
    }

    public CommandeTranslation(ModelePerspective modelePerspective, int dx, int dy)
    {
        super("app.frame.menus.transform.translate");
        this.modelePerspective = modelePerspective;        
        this.dx = dx;
        this.dy = dy;       
        
    }

    @Override
    public void executer() {
        modelePerspective.translater(dx, dy);
    }

    @Override
    public boolean annulable() {
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
    	commandeTranslation();
    	super.actionPerformed(e);
    }
    
    private void commandeTranslation(){
    	Integer _dx = Integer.parseInt(JOptionPane.showInputDialog("Veuillez inserer la coordonnee de x:"));
        Integer _dy = Integer.parseInt(JOptionPane.showInputDialog("Veuillez inserer la coordonnee de y:"));
        
        if(_dx != null && _dy != null){
        	this.dx = _dx;
        	this.dy = _dy;
        }
    }

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Integer _dx = arg0.getX();
		Integer _dy = arg0.getY();
		
		if(_dx != null && _dy != null){			
			this.dx += (_dx-x_before);
			this.dy += (_dy-y_before);
		}
		
		GestionnaireCommandes.getInstance().executer(this);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0 != null){
			x_before = arg0.getX();
			y_before = arg0.getY();
		}		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
