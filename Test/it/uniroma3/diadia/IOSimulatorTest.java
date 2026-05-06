package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IOSimulatorTest {

    @Test
    public void testLeggiRiga() {
        IOSimulator io = new IOSimulator("vai nord", "fine");

        assertEquals("vai nord", io.leggiRiga());
        assertEquals("fine", io.leggiRiga());
    }

    @Test
    public void testMostraMessaggio() {
        IOSimulator io = new IOSimulator();

        io.mostraMessaggio("Ciao");
        io.mostraMessaggio("Benvenuto");

        assertEquals("Ciao", io.getMessaggioMostrato(0));
        assertEquals("Benvenuto", io.getMessaggioMostrato(1));
    }
}