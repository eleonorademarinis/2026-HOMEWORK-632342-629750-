package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	private Labirinto labirinto;

	@Before
	public void setUp() {
		labirinto = Labirinto.newBuilder()
	            .addStanzaIniziale("Atrio")
	            .addStanzaVincente("Biblioteca")
	            .addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
	            .getLabirinto();
	}

	/*
	 * TEST getStanzaCorrente
	 */

	@Test
	public void testGetStanzaCorrenteAllInizio() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaCorrenteDopoSet() {
		Stanza stanza = new Stanza("Nuova stanza");
		labirinto.setStanzaCorrente(stanza);
		assertEquals(stanza, labirinto.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaCorrentePuoEssereNull() {
		labirinto.setStanzaCorrente(null);
		assertNull(labirinto.getStanzaCorrente());
	}

	/* 
	 * TEST setStanzaCorrente
	 */

	@Test
	public void testSetStanzaCorrenteModificaStanzaCorrente() {
		Stanza stanza = new Stanza("Biblioteca segreta");
		labirinto.setStanzaCorrente(stanza);
		assertEquals(stanza, labirinto.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaCorrenteConStanzaVincente() {
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertEquals(labirinto.getStanzaVincente(), labirinto.getStanzaCorrente());
	}

	@Test
	public void testSetStanzaCorrenteConNull() {
		labirinto.setStanzaCorrente(null);
		assertNull(labirinto.getStanzaCorrente());
	}

	/* 
	 * TEST getStanzaVincente
	 */

	@Test
	public void testGetStanzaVincenteNonNull() {
		assertNotNull(labirinto.getStanzaVincente());
	}

	@Test
	public void testGetStanzaVincenteAllInizio() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaVincenteDiversaDaStanzaCorrenteAllInizio() {
		assertFalse(labirinto.getStanzaVincente().equals(labirinto.getStanzaCorrente()));
	}
}