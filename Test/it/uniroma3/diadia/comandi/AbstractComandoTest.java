package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;

class AbstractComandoTest {

    /*
     * Classe finta concreta per poter istanziare
     * AbstractComando
     */
    private class ComandoFinto extends AbstractComando {

        @Override
        public void esegui(Partita partita) {
            // non serve fare nulla
        }
    }

    @Test
    void testSetGetParametro() {

        ComandoFinto comando = new ComandoFinto();

        comando.setParametro("nord");

        assertEquals("nord", comando.getParametro());
    }

    @Test
    void testGetNome() {

        ComandoFinto comando = new ComandoFinto();

        assertEquals("finto", comando.getNome());
    }
}