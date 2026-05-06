package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Partita partita;
	private ComandoVai comandoVai;

	@Before
	public void setUp() {
		partita = new Partita();
		comandoVai = new ComandoVai();
		IO io = new IOConsole();
		this.partita.setIO(io);
	}

	@Test
	public void testVaiDirezioneValidaCambiaStanza() {
		Stanza stanzaIniziale = partita.getLabirinto().getStanzaCorrente();
		Stanza stanzaNord = stanzaIniziale.getStanzaAdiacente("nord");

		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);

		assertEquals(stanzaNord, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistenteNonCambiaStanza() {
		Stanza stanzaIniziale = partita.getLabirinto().getStanzaCorrente();

		comandoVai.setParametro("sopra");
		comandoVai.esegui(partita);

		assertEquals(stanzaIniziale, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneValidaScalaCfu() {
		int cfuIniziali = partita.getGiocatore().getCfu();

		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);

		assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu());
	}
}