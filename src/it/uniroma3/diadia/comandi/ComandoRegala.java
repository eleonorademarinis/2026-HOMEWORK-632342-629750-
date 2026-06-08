package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	
	private static final String MESSAGGIO_COSA = "Cosa vuoi regalare?";
	private static final String MESSAGGIO_NON_HAI = "Non hai questo attrezzo";
	private static final String MESSAGGIO_CON_CHI = "Non c'è nessuno a cui regalarlo";
	
	@Override
	public void esegui(Partita partita) {
		String nomeAttrezzo = this.getParametro();
		
		if (nomeAttrezzo == null) {
			partita.getIO().mostraMessaggio(MESSAGGIO_COSA);
			return;
		}
		
		Borsa borsa = partita.getGiocatore().getBorsa();
		
		if (borsa.hasAttrezzo(nomeAttrezzo)) {
			AbstractPersonaggio personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
			
			if (personaggio == null) {
				partita.getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
				return;
			}
			
			Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
			String messaggio = personaggio.riceviRegalo(attrezzo, partita);
			partita.getIO().mostraMessaggio(messaggio);
		}
		
		else {
			partita.getIO().mostraMessaggio(MESSAGGIO_NON_HAI);
			return;
		}
	}
	
}
