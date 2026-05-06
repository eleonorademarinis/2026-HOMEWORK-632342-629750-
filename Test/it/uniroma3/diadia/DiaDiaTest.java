package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
}