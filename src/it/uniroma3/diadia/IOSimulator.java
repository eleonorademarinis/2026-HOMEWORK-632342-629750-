package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOSimulator implements IO {

    private List<String> righeDaLeggere;
    private List<String> messaggiMostrati;
    private int indiceRiga;

    public IOSimulator(String... righeDaLeggere) {
        this.righeDaLeggere = Arrays.asList(righeDaLeggere);
        this.messaggiMostrati = new ArrayList<>();
        this.indiceRiga = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiMostrati.add(messaggio);
    }

    @Override
    public String leggiRiga() {
        if (this.indiceRiga < this.righeDaLeggere.size()) {
            String riga = this.righeDaLeggere.get(this.indiceRiga);
            this.indiceRiga++;
            return riga;
        }
        return "fine";
    }

    public List<String> getMessaggiMostrati() {
        return this.messaggiMostrati;
    }

    public String getMessaggioMostrato(int indice) {
        return this.messaggiMostrati.get(indice);
    }

    public boolean contieneMessaggio(String messaggio) {
        return this.messaggiMostrati.contains(messaggio);
    }
}