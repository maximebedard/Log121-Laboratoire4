package log121.lab4.app.tests;

import static org.junit.Assert.*;
import log121.lab4.app.Image;
import org.junit.Before;
import org.junit.Test;

public class ImageTest {

	Image img;
	@Before
	public void setUp() throws Exception {
		img = new Image();
	}
	
	@Test
	public void testClone() {
		Image img2 = new Image();
		assertFalse(img2 == img);
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
