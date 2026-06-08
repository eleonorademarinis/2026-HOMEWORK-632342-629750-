package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;

public class Cane extends AbstractPersonaggio {
	
	private String ciboPreferito;
	private Attrezzo attrezzo; 
	
	public Cane (String nome, String presentazione, Attrezzo attrezzo, String ciboPreferito) {
		super(nome, presentazione); 
		this.ciboPreferito = ciboPreferito; 
		this.attrezzo = attrezzo; 
		
	}
	
	@Override
	public String agisci (Partita partita) {
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu - 1);

		return "Il cane ti ha morso! Hai perso 1 CFU.";
	}
		
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		if (attrezzo.getNome().equals(this.ciboPreferito)) {
			String nomeAttrezzoCaduto = this.attrezzo.getNome();
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			return "Il cane accetta il regalo e lascia cadere " + nomeAttrezzoCaduto;
		}
		else {
			return agisci(partita);
		}
		
	}
	
}
