package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita; 
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	public Strega (String nome, String presentazione) {
		super (nome, presentazione); 
	}
	
	
	@Override
	public String agisci (Partita partita) {
		
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente(); 
		Stanza stanzaScelta = null; 
		
		for (Direzione direzione : stanzaCorrente.getDirezioni()) {
			Stanza stanzaAdiacente = stanzaCorrente.getStanzaAdiacente(direzione); 
			
			if (stanzaScelta == null) {
		        stanzaScelta = stanzaAdiacente;
			}
		    
			else if (!this.haSalutato()) {
				if (stanzaAdiacente.getNumeroAttrezzi() < stanzaScelta.getNumeroAttrezzi())
					stanzaScelta = stanzaAdiacente;
			}
			
			else {
				if (stanzaAdiacente.getNumeroAttrezzi() > stanzaScelta.getNumeroAttrezzi())
					stanzaScelta = stanzaAdiacente;
			}	
				
		}
		
		if (stanzaScelta != null) {
		    partita.getLabirinto().setStanzaCorrente(stanzaScelta);
		    return "Ti ho teletrasportato in " + stanzaScelta.getNome();
		}

		return "La strega non sa dove mandarti...";
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "La strega trattiene " + attrezzo.getNome() + " e scoppia a ridere!";
		
	}
	
}
