package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.*;

public class Giocatore {
	
	static final private int CFU_INIZIALI = DiaDiaProperties.getCFUIniziali();
	private int cfu;
	Borsa borsa;
	
	public Giocatore() {
		this.borsa = new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
}
