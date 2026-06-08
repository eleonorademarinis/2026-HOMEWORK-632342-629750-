package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Direzione;
/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

//	static final private int CFU_INIZIALI = 20;

//	private Stanza stanzaCorrente;
//	private Stanza stanzaVincente;
	private boolean finita;
	private IO io;
//	private int cfu;
	Labirinto labirinto;
	Giocatore giocatore;
	
	public Partita(){
		this(Labirinto.newBuilder()
	            .addLabirintoDefault()
	            .getLabirinto());
//		this.cfu = CFU_INIZIALI;
	}
	
	public Partita(Labirinto labirinto) {
		this.labirinto = labirinto; 
		this.giocatore = new Giocatore();
		this.finita = false;
	}

//    /**
//     * Crea tutte le stanze e le porte di collegamento
//     */
//    private void creaStanze() {
//
//		/* crea gli attrezzi */
//    	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
//    	
//		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
//		Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
//		
//		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);
//
//        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);
//
//		// il gioco comincia nell'atrio
//        stanzaCorrente = atrio;  
//		stanzaVincente = biblioteca;
//    }
//
//	public Stanza getStanzaVincente() {
//		return stanzaVincente;
//	}
//
//	public void setStanzaCorrente(Stanza stanzaCorrente) {
//		this.stanzaCorrente = stanzaCorrente;
//	}
//
//	public Stanza getStanzaCorrente() {
//		return this.stanzaCorrente;
//	}
//	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() <= 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

//	public int getCfu() {
//		return this.cfu;
//	}
//
//	public void setCfu(int cfu) {
//		this.cfu = cfu;		
//	}	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public void setIO (IO io) {
		this.io = io; 
		
	}
	
	public IO getIO () {
		return this.io;
	}
}
