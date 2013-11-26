package log121.lab4.app;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import log121.lab4.api.Gardien;
import log121.lab4.api.GestionnaireCommandes;

public class CommandeTranslation extends CommandeAbstraite implements MouseMotionListener{

    private final ModelePerspective modelePerspective;

    private int dx;

    private int dy;

    private final Gardien gardien;    
   

    public CommandeTranslation(ModelePerspective modelePerspective)
    {       	
    	this(modelePerspective,0,0);    	
    }

    public CommandeTranslation(ModelePerspective modelePerspective, int dx, int dy)
    {
        super("app.frame.menus.transform.translate");
        gardien = new Gardien(modelePerspective);
        this.modelePerspective = modelePerspective;        
        this.dx = dx;
        this.dy = dy;       
        
    }

    @Override
    public void executer() {
        gardien.sauvegarder();
        modelePerspective.translater(dx, dy);        
    }

    @Override
    public void annuler() {
        gardien.annuler();
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
    	Integer _dx = Integer.parseInt(JOptionPane.showInputDialog("Veuillez insérer la coordonnée x:"));
        Integer _dy = Integer.parseInt(JOptionPane.showInputDialog("Veuillez insérer la coordonnée y:"));
        
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
			this.dx = _dx;
			this.dy = _dy;
		}
		
		//super.actionPerformed()
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}
}
