package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanza;
	private Stanza biblioteca;
	private Stanza laboratorio;
	private Attrezzo osso;
	private Attrezzo lanterna;

	@Before
	public void setUp() {
		stanza = new Stanza("Atrio");
		biblioteca = new Stanza("Biblioteca");
		laboratorio = new Stanza("Laboratorio");
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
	}

	/*
	 * TEST getStanzaAdiacente
	 */

	@Test
	public void testGetStanzaAdiacentePresente() {
		stanza.impostaStanzaAdiacente(Direzione.nord, biblioteca);
		assertEquals(biblioteca, stanza.getStanzaAdiacente(Direzione.nord));
	}

	@Test
	public void testGetStanzaAdiacenteAssente() {
		assertNull(stanza.getStanzaAdiacente(Direzione.nord));
	}

	@Test
	public void testGetStanzaAdiacenteDopoAggiornamento() {
		stanza.impostaStanzaAdiacente(Direzione.nord, biblioteca);
		stanza.impostaStanzaAdiacente(Direzione.nord, laboratorio);
		assertEquals(laboratorio, stanza.getStanzaAdiacente(Direzione.nord));
	}

	/* 
	 * TEST addAttrezzo
	 */

	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(osso));
	}

	@Test
	public void testAddAttrezzoAggiungeDavveroAttrezzo() {
		stanza.addAttrezzo(osso);
		assertTrue(stanza.hasAttrezzo("osso"));
	}

	@Test
	public void testAddAttrezzoConDueAttrezzi() {
		stanza.addAttrezzo(osso);
		stanza.addAttrezzo(lanterna);
		assertTrue(stanza.hasAttrezzo("lanterna"));
	}

	/*
	 * TEST getAttrezzo
	 */

	@Test
	public void testGetAttrezzoPresente() {
		stanza.addAttrezzo(osso);
		assertEquals(osso, stanza.getAttrezzo("osso"));
	}

	@Test
	public void testGetAttrezzoAssente() {
		assertNull(stanza.getAttrezzo("osso"));
	}

	@Test
	public void testGetAttrezzoConPiuAttrezzi() {
		stanza.addAttrezzo(osso);
		stanza.addAttrezzo(lanterna);
		assertEquals(lanterna, stanza.getAttrezzo("lanterna"));
	}
}