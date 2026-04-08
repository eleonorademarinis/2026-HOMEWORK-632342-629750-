package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	private Partita partita;

	@Before
	public void setUp() {
		partita = new Partita();
	}

	/* 
	 * TEST vinta
	 */

	@Test
	public void testVintaAllInizioFalse() {
		assertFalse(partita.vinta());
	}

	@Test
	public void testVintaRestaFalseSePartitaNonModificata() {
		assertFalse(partita.vinta());
	}

	@Test
	public void testVintaNonImplicaCheSetFinitaSiaStataChiamata() {
		partita.setFinita();
		assertFalse(partita.vinta());
	}

	/* 
	 * TEST isFinita
	 */

	@Test
	public void testIsFinitaAllInizioFalse() {
		assertFalse(partita.isFinita());
	}

	@Test
	public void testIsFinitaTrueDopoSetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

	@Test
	public void testIsFinitaRestaTrueDopoSetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

	/* 
	 * TEST setFinita
	 */

	@Test
	public void testSetFinitaRendePartitaFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

	@Test
	public void testSetFinitaPuòEssereChiamatoUnaVolta() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}

	@Test
	public void testSetFinitaPuòEssereChiamatoDueVolte() {
		partita.setFinita();
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
}
