package log121.lab4.api.tests;

import static org.junit.Assert.*;
import log121.lab4.api.Memento;

import org.junit.Before;
import org.junit.Test;

public class MementoTest {

	Memento<ClonableConcret> memento;
	
	@Before
	public void setUp() throws Exception {
		memento = new Memento<ClonableConcret>(new ClonableConcret());
	}

	@Test
	public void testGetEtat() {

		ClonableConcret clonable = new ClonableConcret();
		
		assertFalse(memento.getEtat() == clonable);
		assertTrue(memento.getEtat().getX() == clonable.getX());
		assertTrue(memento.getEtat().getY() == clonable.getY());
		
	}

}
