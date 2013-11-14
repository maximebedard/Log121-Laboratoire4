package log121.lab4.api.tests;

import static org.junit.Assert.*;
import log121.lab4.api.Memento;

import org.junit.Before;
import org.junit.Test;

public class MementoTest {

	Memento<OriginateurConcret> memento;
	
	@Before
	public void setUp() throws Exception {
		memento = new Memento<OriginateurConcret>(new OriginateurConcret());
	}

	@Test
	public void testGetEtat() {

		OriginateurConcret clonable = new OriginateurConcret();
		
		assertFalse(memento.getEtat() == clonable);
		assertTrue(memento.getEtat().getX() == clonable.getX());
		assertTrue(memento.getEtat().getY() == clonable.getY());
		
	}

}
