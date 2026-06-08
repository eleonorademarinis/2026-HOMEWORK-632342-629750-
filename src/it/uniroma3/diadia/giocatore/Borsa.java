package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.*;
import java.util.*;

public class Borsa {
	
    public static final int DEFAULT_PESO_MAX_BORSA = DiaDiaProperties.getPesoMaxBorsa();;
	
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>(); // speriamo bastino...
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public int getPeso() {
		int peso = 0;
		for (Attrezzo attrezzo : this.attrezzi.values()) 
			peso += attrezzo.getPeso();
		return peso;
	}
	
	public int getPesoMax() {
		return this.pesoMax;
	}
		
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
		
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
		
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {

	    List<Attrezzo> lista = new ArrayList<>(this.attrezzi.values());

	    Collections.sort(lista, new Comparator<Attrezzo>() {

	        @Override
	        public int compare(Attrezzo a1, Attrezzo a2) {

	            int confrontoPeso =
	                    Integer.compare(a1.getPeso(), a2.getPeso());

	            if (confrontoPeso != 0)
	                return confrontoPeso;

	            return a1.getNome().compareTo(a2.getNome());
	        }
	    });

	    return lista;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
	    SortedSet<Attrezzo> insieme = new TreeSet<>(new Comparator<Attrezzo>() {
	        @Override
	        public int compare(Attrezzo a1, Attrezzo a2) {
	            return a1.getNome().compareTo(a2.getNome());
	        }
	    });

	    insieme.addAll(this.attrezzi.values());
	    return insieme;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
	    Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();

	    for (Attrezzo attrezzo : this.attrezzi.values()) {
	        int peso = attrezzo.getPeso();

	        if (!mappa.containsKey(peso)) {
	            mappa.put(peso, new HashSet<Attrezzo>());
	        }

	        mappa.get(peso).add(attrezzo);
	    }

	    return mappa;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {

	    SortedSet<Attrezzo> insieme =
	            new TreeSet<>(new Comparator<Attrezzo>() {

	        @Override
	        public int compare(Attrezzo a1, Attrezzo a2) {

	            int confrontoPeso =
	                    Integer.compare(a1.getPeso(), a2.getPeso());

	            if (confrontoPeso != 0)
	                return confrontoPeso;

	            return a1.getNome().compareTo(a2.getNome());
	        }
	    });

	    insieme.addAll(this.attrezzi.values());

	    return insieme;
	}
		
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (Attrezzo attrezzo : this.getContenutoOrdinatoPerPeso()) {
				s.append(attrezzo.toString() + " ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	

}