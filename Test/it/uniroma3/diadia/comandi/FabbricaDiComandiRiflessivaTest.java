package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiRiflessivaTest {

    private FabbricaDiComandiRiflessiva fabbrica;

    @Before
    public void setUp() {
        fabbrica = new FabbricaDiComandiRiflessiva();
    }

    @Test
    public void testCostruisciComandoVai() {

        Comando comando =
                fabbrica.costruisciComando("vai nord");

        assertTrue(comando instanceof ComandoVai);
    }

    @Test
    public void testCostruisciComandoFine() {

        Comando comando =
                fabbrica.costruisciComando("fine");

        assertTrue(comando instanceof ComandoFine);
    }

    @Test
    public void testComandoInesistenteGeneraComandoNonValido() {

        Comando comando =
                fabbrica.costruisciComando("salta");

        assertTrue(comando instanceof ComandoNonValido);
    }
}
