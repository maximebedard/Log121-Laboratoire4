package log121.lab4.api;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Modele<T extends ICloneable> implements IOriginateur<T>,
		Serializable, ICloneable, ISujet<AttributEvenement> {

	private final ArrayList<IObserveur<AttributEvenement>> observeurs = new ArrayList<IObserveur<AttributEvenement>>();

	@Override
	public void attacher(IObserveur<AttributEvenement> o) {
		observeurs.add(o);
	}

	@Override
	public void detacher(IObserveur<AttributEvenement> o) {
		observeurs.remove(o);
	}

	@Override
	public void notifier(AttributEvenement event) {
		for (IObserveur<AttributEvenement> o : observeurs)
			o.update(event);
	}

	protected void lanceAttributEvenement(String attribut,
			Object ancienneValeur, Object nouvelleValeur) {
		notifier(new AttributEvenement(this, attribut, ancienneValeur,
				nouvelleValeur));
	}

	private static final long serialVersionUID = -8014118939667006520L;

	@Override
	public Object cloneObject() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}

	}

}
