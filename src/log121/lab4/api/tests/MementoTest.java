package log121.lab4.api.tests;

import log121.lab4.api.Memento;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MementoTest {

	private Memento memento;
	
	@Before
	public void setUp() throws Exception {
		memento = new Memento(new OriginateurConcret());
	}

	@Test
	public void testGetEtat() {

		OriginateurConcret clonable = new OriginateurConcret();

        OriginateurConcret mementoClonable = (OriginateurConcret) memento.getEtat();

		assertFalse(memento.getEtat() == clonable);
		assertTrue(mementoClonable.getX() == clonable.getX());
		assertTrue(mementoClonable.getX() == clonable.getY());
		
	}

}
