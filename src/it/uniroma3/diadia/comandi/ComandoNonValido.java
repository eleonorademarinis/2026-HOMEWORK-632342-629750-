package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	@Override
	public void esegui (Partita partita) {
		partita.getIO().mostraMessaggio("questo comando non è valido");  
	}
	
	@Override
    public String getNome() {
        return "non valido";
    }
//
//    @Override
//    public String getParametro() {
//    	return null;
//    }
//    
//	@Override
//	public void setParametro(String parametro) {
//	    // non serve
//	}

}
