package log121.lab4.api;

import java.util.ArrayList;

public class Controleur<T> implements IObserveur<AttrModifieEvenement> {

	private final ArrayList<Vue<T>> vues = new ArrayList<Vue<T>>();

	private final ArrayList<Modele<?>> modeles = new ArrayList<Modele<?>>();

	public void ajouterModele(Modele<?> m) {
		modeles.add(m);
	}

	public void enleverModele(Modele<?> m) {
		modeles.remove(m);
	}

	public void ajouterVue(Vue<T> v) {
		vues.add(v);
	}

	public void enleverVue(Vue<T> v) {
		vues.remove(v);
	}

	@Override
	public void update(AttrModifieEvenement event) {
		for(Vue<T> v : vues)
			v.update(event);
	}
	
}
