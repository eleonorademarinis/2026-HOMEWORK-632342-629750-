package it.uniroma3.diadia;

import java.util.Scanner;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandi.*;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.ambienti.Labirinto;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
//	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
		this.partita.setIO(io);
	}
	
	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(labirinto);
		this.io = io;
		this.partita.setIO(io);
	}

	public void gioca() {
		String istruzione; 
		
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		 FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		    Comando comandoDaEseguire = factory.costruisciComando(istruzione);

		    comandoDaEseguire.esegui(this.partita);

		    if (this.partita.vinta()) {
		        this.io.mostraMessaggio("Hai vinto!");
		        return true;
		    }

		    return this.partita.isFinita();
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
//	private void aiuto() {
//		String messaggio = "";
//		for(int i=0; i< elencoComandi.length; i++) 
//			messaggio += elencoComandi[i] + " ";
//		this.io.mostraMessaggio(messaggio);
//	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
//	private void vai(String direzione) {
//		if(direzione==null)
//			this.io.mostraMessaggio("Dove vuoi andare ?");
//		Stanza prossimaStanza = null;
//		prossimaStanza = this.partita.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
//		if (prossimaStanza == null)
//			this.io.mostraMessaggio("Direzione inesistente");
//		else {
//			this.partita.labirinto.setStanzaCorrente(prossimaStanza);
//			int cfu = this.partita.giocatore.getCfu();
//			this.partita.giocatore.setCfu(cfu-1);
//			
//		}
//		this.io.mostraMessaggio("CFU rimasti: " + this.partita.giocatore.getCfu());
//		this.io.mostraMessaggio(partita.labirinto.getStanzaCorrente().getDescrizione());
//	}
	
	/**
	 * Comando "prendi"
	 */
//	private void prendi(String nomeAttrezzo) {
//		if (nomeAttrezzo == null) {
//			this.io.mostraMessaggio("quale attrezzo vuoi prendere?");
//			return;
//		}
//		
//		Stanza stanza = this.partita.labirinto.getStanzaCorrente();
//		Borsa borsa = this.partita.giocatore.getBorsa();
//		
//		if (!stanza.hasAttrezzo(nomeAttrezzo)) {
//			this.io.mostraMessaggio("questo attrezzo non è presente nella stanza");
//			return;
//		}
//		
//		Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
//		stanza.removeAttrezzo(attrezzo);
//		
//		if (!borsa.addAttrezzo(attrezzo)) {
//			this.io.mostraMessaggio("la tua borsa è troppo piena");
//			stanza.addAttrezzo(attrezzo);
//			return; 
//		}
//		
//		this.io.mostraMessaggio("hai preso " + attrezzo.getNome());
//	}
	
	/**
	 * Comando "posa"
	 */
//	private void posa(String nomeAttrezzo) {
//	    
//		if (nomeAttrezzo == null) {
//			this.io.mostraMessaggio("quale attezzo vuoi posare?");
//			return;
//		}
//		
//		Borsa borsa = this.partita.giocatore.getBorsa();
//		
//		if (!borsa.hasAttrezzo(nomeAttrezzo)) {
//			this.io.mostraMessaggio("non hai questo oggetto");
//			return;
//		}
//		
//		
//		Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
//		 
//		Stanza stanza = this.partita.labirinto.getStanzaCorrente();
//		stanza.addAttrezzo(attrezzo);
//		
//		this.io.mostraMessaggio("hai posato " + attrezzo.getNome());
//	}
//
	/**
	 * Comando "Fine".
	 */
//	private void fine() {
//		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
//	}

	public static void main(String[] argc) {
	    try (Scanner scannerDiLinee = new Scanner(System.in)) {
	        IO io = new IOConsole(scannerDiLinee);
	        DiaDia gioco = new DiaDia(io);
	        gioco.gioca();
	    }
	}
}