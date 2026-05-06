package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	@Override
	public void esegui (Partita partita) {
		partita.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		partita.getIO().mostraMessaggio("CFU: " + partita.getGiocatore().getCfu());
	}
	
	
	@Override
	public void setParametro(String parametro) {
	    // non serve
	}
	
	@Override
    public String getNome() {
        return "guarda";
    }

    @Override
    public String getParametro() {
        return null; // oppure ""
    }

}
