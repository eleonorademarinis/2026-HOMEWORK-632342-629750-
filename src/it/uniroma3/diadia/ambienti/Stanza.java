package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	private String nome;
	private Map<String, Attrezzo> attrezzi;
    private Map<Direzione, Stanza> stanzeAdiacenti;
    private AbstractPersonaggio personaggio;	
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.stanzeAdiacenti = new HashMap<>();
        this.attrezzi = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
    	this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}

    /**
     * Restituisce il nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }


    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        this.attrezzi.put(attrezzo.getNome(), attrezzo);
        return true;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	
    	for (Direzione direzione : this.stanzeAdiacenti.keySet())
    		risultato.append(" " + direzione);
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	
    	for (Attrezzo attrezzo : this.attrezzi.values()) {
    		risultato.append(attrezzo.toString() + " ");
    	}
    	
    	risultato.append("\nPersonaggio nella stanza: ");

    	if (this.personaggio != null)
    	    risultato.append(this.personaggio.getNome());
    	else
    	    risultato.append("nessuno");
    	
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null) 
			return false;
		
		return this.attrezzi.remove(attrezzo.getNome()) != null;
	}


	public Direzione[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new Direzione[0]);
    }
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	public int getNumeroAttrezzi() {
	    return this.attrezzi.size();
	}

}