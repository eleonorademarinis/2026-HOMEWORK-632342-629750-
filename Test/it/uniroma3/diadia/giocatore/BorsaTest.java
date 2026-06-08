package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import java.util.*;

import java.util.SortedSet;

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
	
	@Test
	public void testSortedSetConStessoPesoMantieneEntrambi() {

	    Attrezzo osso = new Attrezzo("osso", 1);
	    Attrezzo chiave = new Attrezzo("chiave", 1);

	    borsa.addAttrezzo(osso);
	    borsa.addAttrezzo(chiave);

	    SortedSet<Attrezzo> insieme =
	            borsa.getSortedSetOrdinatoPerPeso();

	    assertEquals(2, insieme.size());
	}
	
	@Test
	public void testContenutoOrdinatoPerPeso() {

	    Attrezzo piuma = new Attrezzo("piuma", 1);
	    Attrezzo libro = new Attrezzo("libro", 5);

	    borsa.addAttrezzo(libro);
	    borsa.addAttrezzo(piuma);

	    List<Attrezzo> lista =
	            borsa.getContenutoOrdinatoPerPeso();

	    assertEquals(piuma, lista.get(0));
	    assertEquals(libro, lista.get(1));
	}
	
	@Test
	public void testContenutoOrdinatoPerNome() {

	    Attrezzo zaino = new Attrezzo("zaino", 1);
	    Attrezzo libro = new Attrezzo("libro", 1);

	    borsa.addAttrezzo(zaino);
	    borsa.addAttrezzo(libro);

	    SortedSet<Attrezzo> insieme =
	            borsa.getContenutoOrdinatoPerNome();

	    assertEquals("libro", insieme.first().getNome());
	}
	
	@Test
	public void testContenutoRaggruppatoPerPeso() {

	    Attrezzo osso = new Attrezzo("osso", 1);
	    Attrezzo chiave = new Attrezzo("chiave", 1);
	    Attrezzo libro = new Attrezzo("libro", 5);

	    borsa.addAttrezzo(osso);
	    borsa.addAttrezzo(chiave);
	    borsa.addAttrezzo(libro);

	    Map<Integer, Set<Attrezzo>> mappa =
	            borsa.getContenutoRaggruppatoPerPeso();

	    assertEquals(2, mappa.get(1).size());
	    assertEquals(1, mappa.get(5).size());
	}
}