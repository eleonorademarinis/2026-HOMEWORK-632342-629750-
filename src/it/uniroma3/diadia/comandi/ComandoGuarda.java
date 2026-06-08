package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	@Override
	public void esegui (Partita partita) {
		partita.getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		partita.getIO().mostraMessaggio("CFU: " + partita.getGiocatore().getCfu());
		partita.getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}
	
	
//	@Override
//	public void setParametro(String parametro) {
//	    // non serve
//	}
//	
//	@Override
//    public String getNome() {
//        return "guarda";
//    }
//
//    @Override
//    public String getParametro() {
//        return null; // oppure ""
//    }

}
