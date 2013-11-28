package log121.lab4.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class CommandeTranslation extends CommandeAbstraite implements MouseMotionListener{

    private final ModelePerspective modelePerspective;

    private int dx;

    private int dy;
   

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
			/*int x = _dx-this.dx;
			int y = _dy-this.dy;
			System.out.println( x + " : " + y);*/
			System.out.println(_dx + " ;" + _dy);
			this.dx = _dx;
			this.dy = _dy;
		}
		
		GestionnaireCommandes.getInstance().executer(this);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
