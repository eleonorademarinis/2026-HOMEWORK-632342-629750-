package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Direzione;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader; 

import org.junit.jupiter.api.Test;

class CaricatoreLabirintoTest {

	@Test
	public void testMonolocale() throws Exception {
		String fixture = 
				"Stanze: salotto\n" +
				"StanzeSpeciali:\n" +
				"Inizio: salotto\n" +
				"Vincente: salotto\n" +
				"Attrezzi:\n" +
				"Personaggi:\n" +
				"Uscite:\n";
		
		StringReader reader = new StringReader(fixture); 
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(reader);  
        caricatore.carica();
		
		assertEquals("salotto", caricatore.getStanzaIniziale().getNome()); 
		assertEquals("salotto", caricatore.getStanzaVincente().getNome()); 
	}

	@Test
	public void testBilocale() throws Exception {
	    String fixture =
	            "Stanze: salotto, camera\n" +
	            "StanzeSpeciali:\n" +
	            "Inizio: salotto\n" +
	            "Vincente: camera\n" +
	            "Attrezzi:\n" +
	            "Personaggi:\n" +
	            "Uscite: salotto nord camera\n";

	    CaricatoreLabirinto caricatore =
	            new CaricatoreLabirinto(new StringReader(fixture));

	    caricatore.carica();

	    assertEquals("salotto", caricatore.getStanzaIniziale().getNome());
	    assertEquals("camera", caricatore.getStanzaVincente().getNome());
	    assertEquals("camera",
	            caricatore.getStanzaIniziale()
	                      .getStanzaAdiacente(Direzione.nord)
	                      .getNome());
	}
	
	@Test
	public void testAttrezzoInStanza() throws Exception {
	    String fixture =
	            "Stanze: salotto\n" +
	            "StanzeSpeciali:\n" +
	            "Inizio: salotto\n" +
	            "Vincente: salotto\n" +
	            "Attrezzi: martello 10 salotto\n" +
	            "Personaggi:\n" +
	            "Uscite:\n";

	    CaricatoreLabirinto caricatore =
	            new CaricatoreLabirinto(new StringReader(fixture));

	    caricatore.carica();

	    assertTrue(caricatore.getStanzaIniziale().hasAttrezzo("martello"));
	}
	@Test
	public void testStanzaInizialeNonDefinita() {
	    String fixture =
	            "Stanze: salotto\n" +
	            "StanzeSpeciali:\n" +
	            "Inizio: camera\n" +
	            "Vincente: salotto\n" +
	            "Attrezzi:\n" +
	            "Personaggi:\n" +
	            "Uscite:\n";

	    CaricatoreLabirinto caricatore =
	            new CaricatoreLabirinto(new StringReader(fixture));

	    assertThrows(FormatoFileNonValidoException.class, () -> {
	        caricatore.carica();
	    });
	}
}
