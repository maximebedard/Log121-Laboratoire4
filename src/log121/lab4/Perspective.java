package log121.lab4;

public class Perspective extends Modele<PerspectiveEtat> {

	@Override
	public Memento<PerspectiveEtat> sauvegarder() {
		return new Memento<PerspectiveEtat>(this.getState());
	}

	
}
