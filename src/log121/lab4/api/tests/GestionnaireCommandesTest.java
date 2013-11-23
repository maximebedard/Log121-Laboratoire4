package log121.lab4.api.tests;

import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;
import org.junit.Before;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GestionnaireCommandesTest {

	private GestionnaireCommandes manager;

	private boolean valide;

	private class CommandeConcreteDefaisable implements ICommande {

		private final GestionnaireCommandesTest gct;

		public CommandeConcreteDefaisable(GestionnaireCommandesTest gct) {
			this.gct = gct;
		}

		@Override
		public void executer() {
			gct.setValide(true);
		}

		@Override
		public void annuler() {
			gct.setValide(false);
		}

        @Override
        public boolean annulable() {
            return true;
        }
    }

    private class CommandeConcreteNonDefaisable implements ICommande {

        private final GestionnaireCommandesTest gct;

        public CommandeConcreteNonDefaisable(GestionnaireCommandesTest gct) {
            this.gct = gct;
        }

        @Override
        public void executer() {
            gct.setValide(true);
        }

        @Override
        public void annuler() {
            throw new NotImplementedException();
        }

        @Override
        public boolean annulable() {
            return false;
        }
    }

	@Before
	public void setUp() throws Exception {
		manager = GestionnaireCommandes.getInstance();
		setValide(false);
	}

	@Test
	public void testExecuter() {
		assertFalse(valide);

		manager.executer(new CommandeConcreteDefaisable(this));

		assertTrue(valide);
	}

	@Test
	public void testAnnuler() {
		testExecuter();

		manager.annuler();

		assertFalse(valide);
	}

	@Test
	public void testRefaire() {
		testAnnuler();
		
		manager.refaire();
		
		assertTrue(valide);
	}

	/**
	 * @return the valide
	 */
	public boolean isValide() {
		return valide;
	}

	/**
	 * @param valide
	 *            the bidon to set
	 */
    void setValide(boolean valide) {
		this.valide = valide;
	}

}
