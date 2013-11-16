package log121.lab4.api;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Modele implements IOriginateur<ICloneable>,
		Serializable, ICloneable, ISujet<AttrModifieEvenement> {

	private final ArrayList<IObserveur<AttrModifieEvenement>> observeurs = new ArrayList<IObserveur<AttrModifieEvenement>>();

	@Override
	public void attacher(IObserveur<AttrModifieEvenement> o) {
		observeurs.add(o);
	}

	@Override
	public void detacher(IObserveur<AttrModifieEvenement> o) {
		observeurs.remove(o);
	}

	@Override
	public void notifier(AttrModifieEvenement event) {
		for (IObserveur<AttrModifieEvenement> o : observeurs)
			o.update(event);
	}

	protected void lanceAttributEvenement(String attribut,
			Object ancienneValeur, Object nouvelleValeur) {
		notifier(new AttrModifieEvenement(this, attribut, ancienneValeur,
				nouvelleValeur));
	}

	private static final long serialVersionUID = -8014118939667006520L;


    @Override
    public Memento<ICloneable> creerMemento() {
        return new Memento<ICloneable>(this);
    }

	@Override
	public Object cloneObject() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

	}
	
}
