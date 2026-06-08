package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Direzione; 

public class ComandoVai extends AbstractComando {

	
	/*
	 * esecuzione del comando 
	 */
	@Override
	public void esegui(Partita partita) {

	    String parametro = this.getParametro();

	    if (parametro == null) {
	        partita.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
	        return;
	    }

	    Direzione direzione = null;

	    try {
	        direzione = Direzione.valueOf(parametro);
	    } catch (IllegalArgumentException e) {
	        partita.getIO().mostraMessaggio("Direzione inesistente");
	        return;
	    }

	    Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
	    Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);

	    if (prossimaStanza == null) {
	        partita.getIO().mostraMessaggio("Direzione inesistente");
	        return;
	    }

	    partita.getLabirinto().setStanzaCorrente(prossimaStanza);
	    partita.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
	    partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	}
	
//	@Override
//    public String getNome() {
//        return "vai";
//    }
//
//    @Override
//    public String getParametro() {
//        return this.direzione;
//    }
//	 
//	@Override
//	public void setParametro(String parametro) {
//		this.direzione = parametro;
//	}
	
}
