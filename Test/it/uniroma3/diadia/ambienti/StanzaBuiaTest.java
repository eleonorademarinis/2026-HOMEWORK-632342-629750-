package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private Attrezzo lanterna;
	private Attrezzo osso;

	@Before
	public void setUp() {
		stanzaBuia = new StanzaBuia("Atrio", "lanterna");
		lanterna = new Attrezzo("lanterna", 3);
		osso = new Attrezzo("osso", 1);
	}

	@Test
	public void testDescrizioneSenzaLuce() {
		assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
	}

	@Test
	public void testDescrizioneConLuce() {
		stanzaBuia.addAttrezzo(lanterna);

		assertNotEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
	}

	@Test
	public void testDescrizioneNonCambiaConAttrezzoDiverso() {
		stanzaBuia.addAttrezzo(osso);

		assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
	}
}