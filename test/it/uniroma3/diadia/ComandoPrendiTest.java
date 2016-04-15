package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {
	private Stanza stanzaVuota, stanzaPiena, stanzaConAttrezzo;
	private Attrezzo lanterna, osso, pc, libro, lavagna, accendino, banco, telefono, bottiglia, sedia, mouse, temperino;
	private Borsa borsaVuota, borsaPiena, borsaConAttrezzo;
	private Partita partita;
	private Comando comando;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPrendi("temperino");
		this.stanzaConAttrezzo = new Stanza("Stanza Con Attrezzo");
		this.stanzaPiena = new Stanza("Stanza piena");
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.borsaVuota = new Borsa();
		this.borsaConAttrezzo = new Borsa();
		this.borsaPiena = new Borsa();
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		this.temperino = new Attrezzo ("temperino", 1);
		this.accendino = new Attrezzo("accendino", 3);
		this.banco = new Attrezzo("banco", 5);
		this.bottiglia = new Attrezzo("bottiglia", 1);
		this.lavagna = new Attrezzo("lavagna", 10);
		this.libro = new Attrezzo("libro", 3);
		this.pc = new Attrezzo("pc", 1);
		this.sedia = new Attrezzo("sedia", 6);
		this.telefono = new Attrezzo("telefono", 2);
		this.mouse = new Attrezzo("mouse", 2);
		this.stanzaConAttrezzo.impostaUscita("nord", stanzaVuota);
		this.stanzaVuota.impostaUscita("sud", stanzaConAttrezzo);
		stanzaConAttrezzo.addAttrezzo(lanterna);
		stanzaConAttrezzo.addAttrezzo(temperino);
		stanzaConAttrezzo.addAttrezzo(osso);
		stanzaPiena.addAttrezzo(mouse);
		stanzaPiena.addAttrezzo(lanterna);
		stanzaPiena.addAttrezzo(osso);
		stanzaPiena.addAttrezzo(banco);
		stanzaPiena.addAttrezzo(bottiglia);
		stanzaPiena.addAttrezzo(lavagna);
		stanzaPiena.addAttrezzo(libro);
		stanzaPiena.addAttrezzo(pc);
		stanzaPiena.addAttrezzo(sedia);
		stanzaPiena.addAttrezzo(telefono);
		borsaPiena.addAttrezzo(lavagna);
		borsaConAttrezzo.addAttrezzo(lanterna);
		borsaConAttrezzo.addAttrezzo(accendino);
		borsaConAttrezzo.addAttrezzo(pc);
		this.comando.esegui(partita);
	}

	@Test
	public void testPrendiBorsaPiena() {
		this.partita.getGiocatore().setBorsa(borsaPiena);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("temperino"));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("temperino"));
		System.out.println();
	}
	
	@Test
	public void testPrendiAttrezzoNonPresenteNellaStanza() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.setStanzaCorrente(stanzaPiena);
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("temperino"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("temperino"));
		System.out.println();
	}
	
	@Test
	public void testPrendiAttrezzoStanzaVuota() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.setStanzaCorrente(stanzaVuota);
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("temperino"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("temperino"));
		System.out.println();
	}

	@Test
	public void testPrendiAttrezzoNelMezzoConBorsaNonVuota() {
		this.partita.getGiocatore().setBorsa(borsaConAttrezzo);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("temperino"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("temperino"));
		System.out.println();
	}
	
	@Test
	public void testPrendiAttrezzoNelMezzoConBorsaVuota() {
		this.partita.getGiocatore().setBorsa(borsaVuota);
		this.partita.setStanzaCorrente(stanzaConAttrezzo);
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("temperino"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("temperino"));
		System.out.println();
	}
	
}
