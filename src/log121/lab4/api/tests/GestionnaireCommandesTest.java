package log121.lab4.api.tests;

import static org.junit.Assert.*;
import log121.lab4.api.GestionnaireCommandes;
import log121.lab4.api.ICommande;

import org.junit.Before;
import org.junit.Test;

public class GestionnaireCommandesTest {

	GestionnaireCommandes manager;

	private boolean valide;

	private class CommandeConcrete implements ICommande {

		private final GestionnaireCommandesTest gct;

		public CommandeConcrete(GestionnaireCommandesTest gct) {
			this.gct = gct;
		}

		@Override
		public void executer() {
			gct.setValide(true);
		}

		@Override
		public void defaire() {
			gct.setValide(false);
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

		manager.executer(new CommandeConcrete(this));

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
	public void setValide(boolean valide) {
		this.valide = valide;
	}

}
