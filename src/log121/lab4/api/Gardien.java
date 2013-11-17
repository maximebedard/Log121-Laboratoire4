package log121.lab4.api;

import java.util.NoSuchElementException;
import java.util.Stack;

public class Gardien<T extends IOriginateur<ICloneable>> {

	
	public Gardien(T originateur){
		this.originateur = originateur;
	}
	
	private final T originateur;
	
	private final Stack<Memento<ICloneable>> undoStack = new Stack<Memento<ICloneable>>();
	
	private final Stack<Memento<ICloneable>> redoStack = new Stack<Memento<ICloneable>>();
	
	public void sauvegarder()
	{
		undoStack.push(originateur.creerMemento());
	}
	
	public void annuler()
	{
		if(!possedeAnnuler())
			throw new NoSuchElementException();
		
		Memento<ICloneable> memento = undoStack.pop();
		originateur.restaurerMemento(memento);
		redoStack.push(memento);
	}
	
	
	public void refaire()
	{
		if(!possedeRefaire())
			throw new NoSuchElementException();
		
		Memento<ICloneable> memento = redoStack.pop();
		originateur.restaurerMemento(memento);
		undoStack.push(memento);
	}
	
	public boolean possedeAnnuler(){
		return !undoStack.empty();
	}
	
	public boolean possedeRefaire(){
		return !redoStack.empty();
	}
	
	public int nbAnnuler()
	{
		return undoStack.size();
	}
	
	public int nbRefaire()
	{
		return redoStack.size();
	}
	
}
