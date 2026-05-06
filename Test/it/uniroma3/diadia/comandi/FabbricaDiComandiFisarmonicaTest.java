package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;

	@Before
	public void setUp() {
		this.fabbrica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testCostruisciComandoVai() {
		Comando comando = this.fabbrica.costruisciComando("vai nord");

		assertEquals("vai", comando.getNome());
		assertEquals("nord", comando.getParametro());
	}

	@Test
	public void testCostruisciComandoPrendi() {
		Comando comando = this.fabbrica.costruisciComando("prendi osso");

		assertEquals("prendi", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}

	@Test
	public void testCostruisciComandoPosa() {
		Comando comando = this.fabbrica.costruisciComando("posa osso");

		assertEquals("posa", comando.getNome());
		assertEquals("osso", comando.getParametro());
	}

	@Test
	public void testCostruisciComandoAiuto() {
		Comando comando = this.fabbrica.costruisciComando("aiuto");

		assertEquals("aiuto", comando.getNome());
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComandoGuarda() {
		Comando comando = this.fabbrica.costruisciComando("guarda");

		assertEquals("guarda", comando.getNome());
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComandoFine() {
		Comando comando = this.fabbrica.costruisciComando("fine");

		assertEquals("fine", comando.getNome());
		assertNull(comando.getParametro());
	}

	@Test
	public void testCostruisciComandoNonValido() {
		Comando comando = this.fabbrica.costruisciComando("banana");

		assertEquals("non valido", comando.getNome());
		assertNull(comando.getParametro());
	}
}