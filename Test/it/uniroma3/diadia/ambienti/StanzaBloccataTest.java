package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Stanza biblioteca;
	private Stanza laboratorio;
	private Attrezzo chiave;

	@Before
	public void setUp() {
		stanzaBloccata = new StanzaBloccata("Atrio", "chiave", Direzione.nord);
		biblioteca = new Stanza("Biblioteca");
		laboratorio = new Stanza("Laboratorio");
		chiave = new Attrezzo("chiave", 1);

		stanzaBloccata.impostaStanzaAdiacente(Direzione.nord, biblioteca);
		stanzaBloccata.impostaStanzaAdiacente(Direzione.est, laboratorio);
	}

	@Test
	public void testDirezioneBloccataSenzaAttrezzoRestituisceStessaStanza() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente(Direzione.nord));
	}

	@Test
	public void testDirezioneBloccataConAttrezzoRestituisceStanzaAdiacente() {
		stanzaBloccata.addAttrezzo(chiave);

		assertEquals(biblioteca, stanzaBloccata.getStanzaAdiacente(Direzione.nord));
	}

	@Test
	public void testDirezioneNonBloccataRestituisceStanzaAdiacente() {
		assertEquals(laboratorio, stanzaBloccata.getStanzaAdiacente(Direzione.est));
	}

	@Test
	public void testDirezioneInesistenteRestituisceNull() {
		assertNull(stanzaBloccata.getStanzaAdiacente(Direzione.sud));
	}
}