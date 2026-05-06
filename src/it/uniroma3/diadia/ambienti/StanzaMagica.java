package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagica extends Stanza{
	private static final int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagica(String nome) {
	    this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int sogliaMagica) {
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

	    return super.addAttrezzo(attrezzo);
	}
}
