package log121.lab4.app;

import log121.lab4.api.Controleur;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import log121.lab4.api.AttrModifieEvenement;

import log121.lab4.api.Vue;

public class VueTranslation extends Vue {

	private static final long serialVersionUID = 5404684093209799162L;

    public VueTranslation(Controleur<?, ?> controleur) {
        super(controleur);
    }

    @Override
	public void update(AttrModifieEvenement event) {
		throw new NotImplementedException();
	}

	@Override
	public void initComponents() {
		throw new NotImplementedException();
	}

    @Override
    protected void setControleur(Controleur<?, ?> controleur) {
    }

}
