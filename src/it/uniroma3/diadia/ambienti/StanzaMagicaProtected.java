package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
	    this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagicaProtected(String nome, int sogliaMagica) {
	    super(nome);
	    this.contatoreAttrezziPosati = 0;
	    this.sogliaMagica = sogliaMagica;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
	    StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome());
	    nomeInvertito.reverse();

	    int pesoX2 = attrezzo.getPeso() * 2;

	    return new Attrezzo(nomeInvertito.toString(), pesoX2);
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
	    this.contatoreAttrezziPosati++;

	    if (this.contatoreAttrezziPosati > this.sogliaMagica) {
	        attrezzo = this.modificaAttrezzo(attrezzo);
	    }

	    if (this.numeroAttrezzi < this.attrezzi.length) {
            this.attrezzi[this.numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        } else {
            return false;
        }
	}
}
