
package log121.lab4;

import java.util.Observable;

public abstract class Modele<T> extends Observable{

	private Etat<T> state;
	
	public abstract Memento<T> sauvegarder();

	public void restorer(Memento<T> memento) {
		setState(memento.getState());
	}

	public Etat<T> getState() {
		return state;
	}

	public void setState(Etat<T> state) {
		this.state = state;
	}
	
}
