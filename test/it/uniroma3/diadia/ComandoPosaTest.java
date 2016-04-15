package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {
	private Stanza stanzaVuota,stanzaConAttrezzo;
	private Attrezzo lanterna, osso, pc, lavagna, accendino;
	private Borsa borsaVuota, borsaPiena, borsaConAttrezzo;
	private Partita partita;
	private Comando comando;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPosa("accendino");
		this.stanzaConAttrezzo = new Stanza("Stanza Con Attrezzo");
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.borsaVuota = new Borsa();
		this.borsaConAttrezzo = new Borsa();
		this.borsaPiena = new Borsa();
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		this.accendino = new Attrezzo("accendino", 3);
		this.lavagna = new Attrezzo("lavagna", 7);
		this.pc = new Attrezzo("pc", 1);
		this.stanzaConAttrezzo.impostaUscita("nord", stanzaVuota);
		this.stanzaVuota.impostaUscita("sud", stanzaConAttrezzo);
		stanzaConAttrezzo.addAttrezzo(lanterna);
		stanzaConAttrezzo.addAttrezzo(osso);
		borsaPiena.addAttrezzo(lavagna);
		borsaConAttrezzo.addAttrezzo(lanterna);
		borsaConAttrezzo.addAttrezzo(accendino);
		borsaConAttrezzo.addAttrezzo(pc);
		
	}

	@Test
	public void testPosaAttrezzoNonPresenteInBorsa() {
		this.partita.getGiocatore().setBorsa(borsaPiena);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("accendino"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("accendino"));
		System.out.println();
	}
	
	@Test
	public void testPosaAttrezzoBorsaVuota() {
		this.partita.getGiocatore().setBorsa(borsaVuota);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("accendino"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("accendino"));
		System.out.println();
	}
	
	@Test
	public void testPosaAttrezzoNelMezzoConStanzaVuota() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.setStanzaCorrente(stanzaVuota);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("accendino"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("accendino"));
		System.out.println();
	}
	
	@Test
	public void testPosaAttrezzoNelMezzoConStanzaNonVuota() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("accendino"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("accendino"));
		System.out.println();
	}
	
	@Test
	public void testPosaAttrezzo() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.getGiocatore().getBorsa().removeAttrezzo("lanterna");
		this.partita.getGiocatore().getBorsa().removeAttrezzo("pc");
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("accendino"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("accendino"));
		System.out.println();
	}
	
}
