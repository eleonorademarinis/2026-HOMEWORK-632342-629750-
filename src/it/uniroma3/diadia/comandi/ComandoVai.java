package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoVai implements Comando {
	private String direzione;
	
	/*
	 * esecuzione del comando 
	 */
	@Override
	public void esegui (Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		 if (this.direzione == null) {
			 partita.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
	            return;
	        }

	        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

	        if (prossimaStanza == null) {
	        	partita.getIO().mostraMessaggio("Direzione inesistente");
	            return;
	        }

	        partita.getLabirinto().setStanzaCorrente(prossimaStanza);
	        partita.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
	        partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	}
	
	@Override
    public String getNome() {
        return "vai";
    }

    @Override
    public String getParametro() {
        return this.direzione;
    }
	 
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
}
