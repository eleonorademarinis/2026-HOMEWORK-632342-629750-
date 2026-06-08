package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;


public class StanzaBloccata extends Stanza {
	private String attrezzoSbloccante; 
	private Direzione direzioneBloccata;

	public StanzaBloccata (String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
		super(nome); 
		this.attrezzoSbloccante = attrezzoSbloccante; 
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if (direzione.equals(this.direzioneBloccata) && !hasAttrezzo(this.attrezzoSbloccante)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override 
	public String getDescrizione() {
		return super.getDescrizione() + "\n direzione bloccata: " + this.direzioneBloccata; 
	}
}
