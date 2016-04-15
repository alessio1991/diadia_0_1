package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoNonValido;

import org.junit.Before;
import org.junit.Test;

public class ComandoNonValidoTest {
	private Partita partita;
	private Comando comandoNullo, comandoErrato;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comandoNullo = new ComandoNonValido(" ");
		this.comandoErrato = new ComandoNonValido("ciao");
		System.out.println();
	}

	@Test
	public void testComandoNullo() {
		this.comandoNullo.esegui(partita);
		System.out.println();
	}
	
	@Test
	public void testComandoErrato() {
		this.comandoErrato.esegui(partita);
		System.out.println();
	}

}
