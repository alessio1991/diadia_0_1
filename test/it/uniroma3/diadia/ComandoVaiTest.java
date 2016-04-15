package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private Partita partita;
	private Comando comandoNullo, comandoNord, comandoSud, comandoEst, comandoOvest;
	private Stanza stanza;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comandoNullo = new ComandoVai(null);
		this.comandoEst = new ComandoVai("est");
		this.comandoNord = new ComandoVai("nord");
		this.comandoOvest = new ComandoVai("ovest");
		this.comandoSud = new ComandoVai("sud");
		this.stanza = this.partita.getStanzaCorrente();
	}

	@Test
	public void testComandoVaiNullo() {
		this.comandoNullo.esegui(partita);
		assertSame(this.stanza, this.partita.getStanzaCorrente());
		System.out.println();
	}
	
	@Test
	public void testComandoVaiNord() {
		this.comandoNord.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.stanza.getUscita("nord"));
		System.out.println();
	}

	@Test
	public void testComandoVaiSud() {
		this.comandoSud.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.stanza.getUscita("sud"));
		System.out.println();
	}
	
	@Test
	public void testComandoVaiEst() {
		this.comandoEst.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.stanza.getUscita("est"));
		System.out.println();
	}
	
	@Test
	public void testComandoVaiOvest() {
		this.comandoOvest.esegui(partita);
		assertSame(this.partita.getStanzaCorrente(), this.stanza.getUscita("ovest"));
		System.out.println();
	}
}
