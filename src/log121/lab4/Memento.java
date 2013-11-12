package log121.lab4;

public class Memento<T> {

	private final Etat<T> state;

	public Memento(Etat<T> state) {
		this.state = state;
	}
	
	public Etat<T> getState() {
		return state;
	}

}
