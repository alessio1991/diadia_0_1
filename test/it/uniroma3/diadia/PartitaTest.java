package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	private Partita partita;
	private Stanza stanzaNonVincente;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.stanzaNonVincente = new Stanza("Lab");
	}


	@Test
	public void testVinta() {
		assertFalse(this.partita.vinta());
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testIsFinita() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
		this.partita.getGiocatore().setCfu(20);
		assertFalse(this.partita.isFinita());
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
		this.partita.setStanzaCorrente(stanzaNonVincente);
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testSetFinita() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}


	@Test
	public void testGiocatoreIsVivo() {
		assertTrue(this.partita.giocatoreIsVivo());
		this.partita.getGiocatore().setCfu(0);
		assertFalse(this.partita.giocatoreIsVivo());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		this.partita.setStanzaCorrente(this.stanzaNonVincente);
		assertSame(this.partita.getStanzaCorrente(), this.stanzaNonVincente);
	}

	@Test
	public void testGetStanzaCorrente() {
		assertSame(this.partita.getStanzaCorrente(), this.partita.getLabirinto().getStanzaIniziale());
	}

}
