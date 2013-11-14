package log121.lab4.app.tests;

import static org.junit.Assert.*;
import log121.lab4.app.Perspective;

import org.junit.Before;
import org.junit.Test;

public class PerspectiveTest {

	private Perspective p;

	@Before
	public void setUp() throws Exception {
		p = new Perspective();
	}

	@Test
	public void testClone() {
		Perspective p2 = new Perspective();
		assertFalse(p2 == p);
	}

	@Test
	public void testCreerMemento() {
		fail("Not yet implemented");
	}

	@Test
	public void testRestaurerMemento() {
		fail("Not yet implemented");
	}

}
