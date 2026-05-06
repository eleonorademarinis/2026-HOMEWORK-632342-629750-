package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo osso;
	private Attrezzo lanterna;
	private Attrezzo spada;
	private Attrezzo libro;

	@Before
	public void setUp() {
		stanzaMagica = new StanzaMagica("Stanza magica");
		osso = new Attrezzo("osso", 1);
		lanterna = new Attrezzo("lanterna", 3);
		spada = new Attrezzo("spada", 5);
		libro = new Attrezzo("libro", 2);
	}

	@Test
	public void testAddAttrezzoPrimaDellaSogliaNonModificaAttrezzo() {
		stanzaMagica.addAttrezzo(osso);

		assertTrue(stanzaMagica.hasAttrezzo("osso"));
	}

	@Test
	public void testAddAttrezzoAllaSogliaNonModificaAttrezzo() {
		stanzaMagica.addAttrezzo(osso);
		stanzaMagica.addAttrezzo(lanterna);
		stanzaMagica.addAttrezzo(spada);

		assertTrue(stanzaMagica.hasAttrezzo("spada"));
	}

	@Test
	public void testAddAttrezzoDopoSogliaModificaNomeAttrezzo() {
		stanzaMagica.addAttrezzo(osso);
		stanzaMagica.addAttrezzo(lanterna);
		stanzaMagica.addAttrezzo(spada);
		stanzaMagica.addAttrezzo(libro);

		assertTrue(stanzaMagica.hasAttrezzo("orbil"));
	}

	@Test
	public void testAddAttrezzoDopoSogliaNonMantieneNomeOriginale() {
		stanzaMagica.addAttrezzo(osso);
		stanzaMagica.addAttrezzo(lanterna);
		stanzaMagica.addAttrezzo(spada);
		stanzaMagica.addAttrezzo(libro);

		assertFalse(stanzaMagica.hasAttrezzo("libro"));
	}

	@Test
	public void testAddAttrezzoDopoSogliaRaddoppiaPeso() {
		stanzaMagica.addAttrezzo(osso);
		stanzaMagica.addAttrezzo(lanterna);
		stanzaMagica.addAttrezzo(spada);
		stanzaMagica.addAttrezzo(libro);

		assertEquals(4, stanzaMagica.getAttrezzo("orbil").getPeso());
	}

	@Test
	public void testSogliaMagicaPersonalizzataModificaSecondoAttrezzo() {
		StanzaMagica stanza = new StanzaMagica("Stanza", 1);
		stanza.addAttrezzo(osso);
		stanza.addAttrezzo(libro);

		assertTrue(stanza.hasAttrezzo("orbil"));
	}
}