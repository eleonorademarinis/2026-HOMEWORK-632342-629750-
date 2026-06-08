package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Direzione; 
import it.uniroma3.diadia.ambienti.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

public class DiaDiaTest {

    @Test
    public void testPartitaFinisceConFine() {
        IOSimulator io = new IOSimulator("fine");

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.getMessaggiMostrati().size() > 0);
    }
    
    @Test
    public void testSequenzaComandi() {
        IOSimulator io = new IOSimulator("fine");

        DiaDia gioco = new DiaDia(io);
        gioco.gioca();

        assertTrue(io.getMessaggiMostrati().size() > 0);
    }
    
    @Test
    public void testPartitaVintaConVaiNord() {

    	Labirinto labirinto = Labirinto.newBuilder()
    	        .addStanzaIniziale("atrio")
    	        .addStanzaVincente("biblioteca")
    	        .addAdiacenza("atrio", "biblioteca", Direzione.nord)
    	        .getLabirinto();

        IOSimulator io = new IOSimulator("vai nord");

        DiaDia gioco = new DiaDia(labirinto, io);

        gioco.gioca();

        assertTrue(io.contieneMessaggio("Hai vinto!"));
    }
}