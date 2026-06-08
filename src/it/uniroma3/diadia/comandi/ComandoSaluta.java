package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


public class ComandoSaluta extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI =
			"Con chi dovrei parlare?...";

	private String messaggio;

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();

		if (personaggio!=null) {
			this.messaggio = personaggio.saluta();
			partita.getIO().mostraMessaggio(this.messaggio);
		} else partita.getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
}