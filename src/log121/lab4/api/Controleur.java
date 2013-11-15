package log121.lab4.api;

import java.util.ArrayList;

public class Controleur implements IObserveur<AttrModifieEvenement> {

	private final ArrayList<Vue> vues = new ArrayList<Vue>();

	private final ArrayList<Modele<?>> modeles = new ArrayList<Modele<?>>();

	public void ajouterModele(Modele<?> m) {
		modeles.add(m);
	}

	public void enleverModele(Modele<?> m) {
		modeles.remove(m);
	}

	public void ajouterVue(Vue v) {
		vues.add(v);
	}

	public void enleverVue(Vue v) {
		vues.remove(v);
	}

	@Override
	public void update(AttrModifieEvenement event) {
		for(Vue v : vues)
			v.update(event);
	}
	
}
