package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi extends AbstractComando {
	
	
	/*
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		
		String nomeAttrezzo = this.getParametro();
		
		if (nomeAttrezzo == null) {
			partita.getIO().mostraMessaggio("quale attrezzo vuoi prendere?");
			return;
		}
		
		Stanza stanza = partita.getLabirinto().getStanzaCorrente();
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		if (!stanza.hasAttrezzo(nomeAttrezzo)) {
			partita.getIO().mostraMessaggio("questo attrezzo non è presente nella stanza");
			return;
		}
		
		Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
		stanza.removeAttrezzo(attrezzo);
		
		if (!borsa.addAttrezzo(attrezzo)) {
			partita.getIO().mostraMessaggio("la tua borsa è troppo piena");
			stanza.addAttrezzo(attrezzo);
			return; 
		}
		
		partita.getIO().mostraMessaggio("hai preso " + attrezzo.getNome());
	}
	
//	@Override
//    public String getNome() {
//        return "prendi";
//    }
//
//    @Override
//    public String getParametro() {
//        return this.nomeAttrezzo;
//    }
//	
//	@Override
//	public void setParametro(String parametro) {
//		this.nomeAttrezzo = parametro;
//	}
}
