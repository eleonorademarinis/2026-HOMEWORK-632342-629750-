package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo pesante;

	@Before
	public void setUp() {
		borsa = new Borsa();
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
		pesante = new Attrezzo("pietra", 20);
	}

	/* 
	 * TEST addAttrezzo
	 */

	@Test
	public void testAddAttrezzoLeggero() {
		assertTrue(borsa.addAttrezzo(osso));
	}

	@Test
	public void testAddAttrezzoTroppoPesante() {
		assertFalse(borsa.addAttrezzo(pesante));
	}

	@Test
	public void testAddAttrezzoAggiungeDavvero() {
		borsa.addAttrezzo(osso);
		assertTrue(borsa.hasAttrezzo("osso"));
	}

	/* 
	 * TEST getAttrezzo
	 */

	@Test
	public void testGetAttrezzoPresente() {
		borsa.addAttrezzo(osso);
		assertEquals(osso, borsa.getAttrezzo("osso"));
	}

	@Test
	public void testGetAttrezzoAssente() {
		assertNull(borsa.getAttrezzo("osso"));
	}

	@Test
	public void testGetAttrezzoConPiuElementi() {
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(lanterna);
		assertEquals(lanterna, borsa.getAttrezzo("lanterna"));
	}

	/*
	 * TEST removeAttrezzo
	 */

	@Test
	public void testRemoveAttrezzoPresente() {
		borsa.addAttrezzo(osso);
		assertEquals(osso, borsa.removeAttrezzo("osso"));
	}

	@Test
	public void testRemoveAttrezzoAssente() {
		assertNull(borsa.removeAttrezzo("osso"));
	}

	@Test
	public void testRemoveAttrezzoRimuoveDavvero() {
		borsa.addAttrezzo(osso);
		borsa.removeAttrezzo("osso");
		assertFalse(borsa.hasAttrezzo("osso"));
	}
}