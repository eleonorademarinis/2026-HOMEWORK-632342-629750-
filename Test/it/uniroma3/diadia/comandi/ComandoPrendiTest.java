package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
public class ComandoPrendiTest {

	private Partita partita;
	private ComandoPrendi comandoPrendi;

	@Before
	public void setUp() {
		partita = new Partita();
		comandoPrendi = new ComandoPrendi();
		IO io = new IOConsole();
		this.partita.setIO(io);
	}

	@Test
	public void testPrendiAttrezzoPresenteAggiungeAllaBorsa() {
		comandoPrendi.setParametro("osso");
		comandoPrendi.esegui(partita);

		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

	@Test
	public void testPrendiAttrezzoPresenteRimuoveDallaStanza() {
		comandoPrendi.setParametro("osso");
		comandoPrendi.esegui(partita);

		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("osso"));
	}

	@Test
	public void testPrendiAttrezzoNonPresenteNonAggiungeAllaBorsa() {
		comandoPrendi.setParametro("spada");
		comandoPrendi.esegui(partita);

		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
	}
}