package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	@Override
	public void esegui(Partita partita) {
		partita.getIO().mostraMessaggio("I comandi disponibili sono:");

		for (String nomeComando : AbstractComando.getElencoComandi()) {
			partita.getIO().mostraMessaggio(nomeComando);
		}
	}	
	
//	/*
//	 * esecuzione del comando 
//	 */
//	@Override
//	public void esegui(Partita partita) {
//		 partita.getIO().mostraMessaggio("I comandi disponibili sono:");
//		 partita.getIO().mostraMessaggio("vai");
//		 partita.getIO().mostraMessaggio("aiuto");
//		 partita.getIO().mostraMessaggio("fine");
//		 partita.getIO().mostraMessaggio("prendi");
//		 partita.getIO().mostraMessaggio("posa");
//		 partita.getIO().mostraMessaggio("guarda");
//	}
//	
//	@Override
//	public void setParametro(String parametro) {
//	    // non serve
//	}
//	
//	@Override
//    public String getNome() {
//        return "aiuto";
//    }
//
//    @Override
//    public String getParametro() {
//        return null; // oppure ""
//    }

}
