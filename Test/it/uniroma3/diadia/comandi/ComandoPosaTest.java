package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class ComandoPosaTest {

	private Partita partita;
	private ComandoPosa comandoPosa;
	private Attrezzo spada;

	@Before
	public void setUp() {
		partita = new Partita();
		comandoPosa = new ComandoPosa();
		spada = new Attrezzo("spada", 1);
		
		IO io = new IOSimulator();
		this.partita.setIO(io);
	}

	@Test
	public void testPosaAttrezzoRimuoveDaBorsa() {
		partita.getGiocatore().getBorsa().addAttrezzo(spada);

		comandoPosa.setParametro("spada");
		comandoPosa.esegui(partita);

		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
	}

	@Test
	public void testPosaAttrezzoAggiungeAllaStanza() {
		partita.getGiocatore().getBorsa().addAttrezzo(spada);

		comandoPosa.setParametro("spada");
		comandoPosa.esegui(partita);

		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("spada"));
	}

	@Test
	public void testPosaAttrezzoNonPresenteNonAggiungeAllaStanza() {
		comandoPosa.setParametro("spada");
		comandoPosa.esegui(partita);

		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("spada"));
	}
}
