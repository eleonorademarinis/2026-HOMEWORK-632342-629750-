package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.personaggi.Cane;

public class Labirinto {
	
	Stanza stanzaVincente;
	Stanza stanzaCorrente;
	
	private Labirinto() {
	}
	
	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
//    private void creaStanze() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//		Attrezzo passepartout = new Attrezzo("passepartout", 1);
//		Attrezzo chiave = new Attrezzo("chiave", 1);
//
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new StanzaBuia("Aula N11", "lanterna");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new StanzaBloccata("Laboratorio Campus", "passepartout", Direzione.ovest);
//		Stanza biblioteca = new Stanza("Biblioteca");
//		
//		/* crea personaggi */
//		Mago merlino = new Mago("Merlino", "Sono un potente mago!", new Attrezzo("bacchetta", 2));
//		Strega morgana = new Strega("Morgana", "Meglio non farmi arrabbiare!");
//		Cane fido = new Cane("Fido", "Bau bau!", new Attrezzo("collare", 1), "osso");
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente(Direzione.nord, biblioteca);
//		atrio.impostaStanzaAdiacente(Direzione.est, aulaN11);
//		atrio.impostaStanzaAdiacente(Direzione.sud, aulaN10);
//		atrio.impostaStanzaAdiacente(Direzione.ovest, laboratorio);
//		aulaN11.impostaStanzaAdiacente(Direzione.est, laboratorio);
//		aulaN11.impostaStanzaAdiacente(Direzione.ovest, atrio);
//		aulaN10.impostaStanzaAdiacente(Direzione.nord, atrio);
//		aulaN10.impostaStanzaAdiacente(Direzione.est, aulaN11);
//		aulaN10.impostaStanzaAdiacente(Direzione.ovest, laboratorio);
//		laboratorio.impostaStanzaAdiacente(Direzione.est, atrio);
//		laboratorio.impostaStanzaAdiacente(Direzione.ovest, aulaN11);
//		biblioteca.impostaStanzaAdiacente(Direzione.sud, atrio);
//
//        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//		aulaN10.addAttrezzo(passepartout);
//		laboratorio.addAttrezzo(chiave);
//		
//		/* pone i personaggi nelle stanze */
//		atrio.setPersonaggio(merlino);
//		aulaN11.setPersonaggio(morgana);
//		aulaN10.setPersonaggio(fido);
//
//		// il gioco comincia nell'atrio
//        stanzaCorrente = atrio;  
//		stanzaVincente = biblioteca;
//    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
	    this.stanzaVincente = stanzaVincente;
	}
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Map<String, Stanza> stanze;
		private Stanza ultimaStanzaAggiunta;
		
		private LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.stanze = new HashMap<>();
		}
		
		private Stanza getStanza(String nome) {
		    Stanza stanza = this.stanze.get(nome);

		    if (stanza == null) {
		        stanza = new Stanza(nome);
		        this.stanze.put(nome, stanza);
		    }

		    this.ultimaStanzaAggiunta = stanza;
		    return stanza;
		}
		
		public LabirintoBuilder addStanza(String nome) {
		    this.getStanza(nome);
		    return this;
		}

		public LabirintoBuilder addStanzaIniziale(String nome) {
		    Stanza stanza = this.getStanza(nome);
		    this.labirinto.setStanzaCorrente(stanza);
		    return this;
		}

		public LabirintoBuilder addStanzaVincente(String nome) {
		    Stanza stanza = this.getStanza(nome);
		    this.labirinto.setStanzaVincente(stanza);
		    return this;
		}
		
		public LabirintoBuilder addAdiacenza(String nomeStanzaPartenza,String nomeStanzaArrivo, Direzione direzione) {

			Stanza partenza = this.getStanza(nomeStanzaPartenza);
			Stanza arrivo = this.getStanza(nomeStanzaArrivo);

			partenza.impostaStanzaAdiacente(direzione, arrivo);

			return this;
		}
		
		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		    Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);

		    this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);

		    return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso, String nomeStanza) {
		    Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);

		    Stanza stanza = this.getStanza(nomeStanza);
		    stanza.addAttrezzo(attrezzo);

		    return this;
		}
		
		public LabirintoBuilder addMago(String nome, String presentazione, String nomeStanza, String nomeAttrezzo, int peso) {
			Stanza stanza = this.getStanza(nomeStanza);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso); 
			
			Mago mago = new Mago(nome, presentazione, attrezzo); 
			
			stanza.setPersonaggio(mago);
			
			return this; 
		}
		
		public LabirintoBuilder addStrega(String nome, String presentazione, String nomeStanza) {
			Stanza stanza = this.getStanza(nomeStanza);
		
			Strega strega = new Strega(nome, presentazione);
			
			stanza.setPersonaggio(strega);
			
			return this;
		}
		
		public LabirintoBuilder addCane(String nome, String presentazione, String nomeStanza, String nomeAttrezzo, int peso, String ciboPreferito) {
			Stanza stanza = this.getStanza(nomeStanza);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			
			Cane cane = new Cane(nome, presentazione, attrezzo, ciboPreferito);
			
			stanza.setPersonaggio(cane);
			
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
			this.stanze.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza; 
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String luce) {
			Stanza stanza = new StanzaBuia(nome, luce);
			this.stanze.put(nome, stanza);
			this.ultimaStanzaAggiunta = stanza; 
			return this;
		}
		
		public LabirintoBuilder addLabirintoDefault() {
		    return this
		        .addStanzaIniziale("Atrio")
		        .addStanzaBuia("Aula N11", "lanterna")
		        .addStanza("Aula N10")
		        .addStanzaBloccata("Laboratorio Campus", "passepartout", Direzione.ovest)
		        .addStanzaVincente("Biblioteca")

		        .addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
		        .addAdiacenza("Atrio", "Aula N11", Direzione.est)
		        .addAdiacenza("Atrio", "Aula N10", Direzione.sud)
		        .addAdiacenza("Atrio", "Laboratorio Campus", Direzione.ovest)

		        .addAdiacenza("Aula N11", "Laboratorio Campus", Direzione.est)
		        .addAdiacenza("Aula N11", "Atrio", Direzione.ovest)

		        .addAdiacenza("Aula N10", "Atrio", Direzione.nord)
		        .addAdiacenza("Aula N10", "Aula N11", Direzione.est)
		        .addAdiacenza("Aula N10", "Laboratorio Campus", Direzione.ovest)

		        .addAdiacenza("Laboratorio Campus", "Atrio", Direzione.est)
		        .addAdiacenza("Laboratorio Campus", "Aula N11", Direzione.ovest)

		        .addAdiacenza("Biblioteca", "Atrio", Direzione.sud)

		        .addAttrezzo("lanterna", 3, "Aula N10")
		        .addAttrezzo("osso", 1, "Atrio")
		        .addAttrezzo("passepartout", 1, "Aula N10")
		        .addAttrezzo("chiave", 1, "Laboratorio Campus")

		        .addMago("Merlino", "Sono-un-potente-mago", "Atrio", "bacchetta", 2)
		        .addStrega("Morgana", "Meglio-non-farmi-arrabbiare", "Aula N11")
		        .addCane("Fido", "Bau-bau", "Aula N10", "collare", 1, "osso");
		}
		
		public Labirinto getLabirinto() {
		    return this.labirinto;
		}
		
	}

	
}
