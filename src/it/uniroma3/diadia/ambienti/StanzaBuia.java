package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaBuia extends Stanza {
	private String luce; 
	
	public StanzaBuia (String nome, String luce) {
	super(nome); 
	this.luce = luce; 
	}
	
	@Override 
	public String getDescrizione() {
		if (this.hasAttrezzo(this.luce)) {
			return super.getDescrizione(); 
		}
		return "qui c'è buio pesto";
	}
}
