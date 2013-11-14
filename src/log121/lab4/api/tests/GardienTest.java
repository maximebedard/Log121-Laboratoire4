package log121.lab4.api.tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import log121.lab4.api.Gardien;

import org.junit.Before;
import org.junit.Test;

public class GardienTest {

	private Gardien<ClonableConcret> gardien;
	private ClonableConcret clonable;
	
	
	@Before
	public void setUp() throws Exception {
		clonable = new ClonableConcret();
		gardien = new Gardien<ClonableConcret>(clonable);
	}

	@Test
	public void testSauvegarder() {
		assertFalse(gardien.possedeAnnuler());
		assertFalse(gardien.possedeRefaire());
		
		clonable.setX(50);
		clonable.setY(100);
		
		gardien.sauvegarder();
		
		assertTrue(gardien.possedeAnnuler());
		assertFalse(gardien.possedeRefaire());
		
		gardien.sauvegarder();
		gardien.sauvegarder();
		
		assertEquals(3, gardien.nbAnnuler());
		assertEquals(0, gardien.nbRefaire());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testAnnulerVide() 
	{
		gardien.annuler();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRefaireVide() 
	{
		gardien.refaire();
	}

	@Test
	public void testAnnuler()
	{
		clonable.setX(10);
		clonable.setY(20);
		gardien.sauvegarder();

		clonable.setX(15);
		clonable.setY(25);
		gardien.sauvegarder();

		clonable.setX(20);
		clonable.setY(30);

		assertEquals(20, clonable.getX());
		assertEquals(30, clonable.getY());
		
		gardien.annuler();
		
		assertEquals(15, clonable.getX());
		assertEquals(25, clonable.getY());
		
		gardien.annuler();
		
		assertEquals(10, clonable.getX());
		assertEquals(20, clonable.getY());		
	}
	
	@Test
	public void testRefaire()
	{
		testAnnuler();
		
		gardien.refaire();
		
		assertEquals(10, clonable.getX());
		assertEquals(20, clonable.getY());
		
		gardien.refaire();
		
		assertEquals(15, clonable.getX());
		assertEquals(25, clonable.getY());
		
	}
}
