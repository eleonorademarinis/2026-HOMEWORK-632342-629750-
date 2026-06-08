package it.uniroma3.diadia.comandi;

import java.util.Set;
import java.util.HashSet;

public abstract class AbstractComando implements Comando {
	
	private String parametro;
//	private static Set<String> elencoComandi = new HashSet<>();
	
	private static Set<String> elencoComandi = new HashSet<>();

	static {
	    elencoComandi.add("vai");
	    elencoComandi.add("aiuto");
	    elencoComandi.add("fine");
	    elencoComandi.add("prendi");
	    elencoComandi.add("posa");
	    elencoComandi.add("guarda");
	    elencoComandi.add("regala");
	    elencoComandi.add("interagisci");
	    elencoComandi.add("saluta");
	}
	
//	public AbstractComando() {
//	    elencoComandi.add(this.getNome());
//	}
	
	@Override 
	public void setParametro (String parametro) {
		this.parametro = parametro; 
	}
	
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public String getNome() {
		String nomeClasse = this.getClass().getSimpleName();
		return nomeClasse.substring("Comando".length()).toLowerCase(); 
	}
	
	public static Set<String> getElencoComandi() {
	    return elencoComandi;
	}

}
