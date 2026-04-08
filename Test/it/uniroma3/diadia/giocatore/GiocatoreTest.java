package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore giocatore;

	@Before
	public void setUp() {
		giocatore = new Giocatore();
	}

	/*
	 * TEST getCfu
	 */

	@Test
	public void testGetCfuAllInizio() {
		assertEquals(20, giocatore.getCfu());
	}

	@Test
	public void testGetCfuDopoSetCfu() {
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
	}

	@Test
	public void testGetCfuDopoSetCfuAZero() {
		giocatore.setCfu(0);
		assertEquals(0, giocatore.getCfu());
	}

	/*
	 * TEST setCfu
	 */

	@Test
	public void testSetCfuModificaValore() {
		giocatore.setCfu(15);
		assertEquals(15, giocatore.getCfu());
	}

	@Test
	public void testSetCfuConValoreMinore() {
		giocatore.setCfu(5);
		assertEquals(5, giocatore.getCfu());
	}

	@Test
	public void testSetCfuConValoreMaggiore() {
		giocatore.setCfu(30);
		assertEquals(30, giocatore.getCfu());
	}

	/* 
	 * TEST getBorsa
	*/

	@Test
	public void testGetBorsaNonNull() {
		assertNotNull(giocatore.getBorsa());
	}

	@Test
	public void testGetBorsaRestituisceSempreLaStessaBorsa() {
		assertEquals(giocatore.getBorsa(), giocatore.getBorsa());
	}

	@Test
	public void testGetBorsaAllInizioVuota() {
		assertTrue(giocatore.getBorsa().isEmpty());
	}
}