package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.Partita;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";

	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;

		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}

		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		int pesoDimezzato = attrezzo.getPeso() / 2; 
		Attrezzo attrezzoAlleggerito = new Attrezzo(attrezzo.getNome(), pesoDimezzato); 
		
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoAlleggerito);
		
		return "ho apprezzato il tuo regalo! L'ho alleggerito e l'ho posato";
	}
}