package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando {
	
	
	/*
	 * esecuzione del comando
	 */
	 
	@Override
	public void esegui (Partita partita) {
		
		String nomeAttrezzo = this.getParametro();
		
		if (nomeAttrezzo == null) {
			partita.getIO().mostraMessaggio("quale attrezzo vuoi posare?");
			return;
		}
			
		Borsa borsa = partita.getGiocatore().getBorsa();
			
		if (!borsa.hasAttrezzo(nomeAttrezzo)) {
			partita.getIO().mostraMessaggio("non hai questo oggetto");
			return;
		}
			
			
		Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
			 
		Stanza stanza = partita.getLabirinto().getStanzaCorrente();
		stanza.addAttrezzo(attrezzo);
			
		partita.getIO().mostraMessaggio("hai posato " + attrezzo.getNome());

	}
	
//	@Override
//    public String getNome() {
//        return "posa";
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
//

}
