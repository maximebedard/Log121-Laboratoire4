package log121.lab4.app.tests;

import log121.lab4.app.ModelePerspective;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class PerspectiveTest {

	private ModelePerspective p;

	@Before
	public void setUp() throws Exception {
		p = new ModelePerspective();
	}

	@Test
	public void testClone() {
		ModelePerspective p2 = new ModelePerspective();
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
