package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza stanzaConAttrezzo, stanzaVuota, stanzaPiena, stanzaNulla;
	private Attrezzo lanterna, osso, pc, libro, lavagna, accendino, banco, telefono, bottiglia, sedia;
	
	@Before
	public void setUp() throws Exception {
		this.stanzaConAttrezzo = new Stanza("Stanza Con Attrezzo");
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.stanzaPiena = new Stanza("Stanza piena");
		this.stanzaNulla = new Stanza(null);
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		this.accendino = new Attrezzo("accendino", 3);
		this.banco = new Attrezzo("banco", 5);
		this.bottiglia = new Attrezzo("bottiglia", 1);
		this.lavagna = new Attrezzo("lavagna", 10);
		this.libro = new Attrezzo("libro", 3);
		this.pc = new Attrezzo("pc", 7);
		this.sedia = new Attrezzo("sedia", 6);
		this.telefono = new Attrezzo("telefono", 2);
		this.stanzaConAttrezzo.impostaUscita("nord", stanzaVuota);
		this.stanzaConAttrezzo.impostaUscita("sud", stanzaPiena);
		this.stanzaVuota.impostaUscita("sud", stanzaConAttrezzo);
		this.stanzaNulla.impostaUscita("sud", stanzaPiena);
		this.stanzaPiena.impostaUscita("est", stanzaNulla);
		stanzaConAttrezzo.addAttrezzo(lanterna);
		stanzaConAttrezzo.addAttrezzo(osso);
		stanzaPiena.addAttrezzo(accendino);
		stanzaPiena.addAttrezzo(lanterna);
		stanzaPiena.addAttrezzo(osso);
		stanzaPiena.addAttrezzo(banco);
		stanzaPiena.addAttrezzo(bottiglia);
		stanzaPiena.addAttrezzo(lavagna);
		stanzaPiena.addAttrezzo(libro);
		stanzaPiena.addAttrezzo(pc);
		stanzaPiena.addAttrezzo(sedia);
		stanzaPiena.addAttrezzo(telefono);
	}

	@Test
	public void testGetUscitaVuota() {
		stanzaConAttrezzo.impostaUscita(" ", stanzaNulla);
		assertEquals(stanzaConAttrezzo.getUscita(" "), stanzaNulla);
		stanzaVuota.impostaUscita(" ", stanzaConAttrezzo);
		assertEquals(stanzaVuota.getUscita(" "), stanzaConAttrezzo);
		assertEquals(stanzaVuota.getUscita("sud"), stanzaConAttrezzo);
		stanzaNulla.impostaUscita(" ", stanzaPiena);
		assertEquals(stanzaNulla.getUscita(" "), stanzaPiena);
	}
	
	@Test
	public void testGetuscita() {
		assertEquals(stanzaConAttrezzo.getUscita("nord"), stanzaVuota);
		assertEquals(stanzaNulla.getUscita("sud"), stanzaPiena);
	}

	@Test
	public void testGetNomeStanza() {
		assertEquals(stanzaConAttrezzo.getNome(), "Stanza Con Attrezzo");
		assertEquals(stanzaNulla.getNome(), null);
	}
	
	@Test
	public void testAddAttrezzoNullo() {
		stanzaConAttrezzo.addAttrezzo(null);
		assertEquals(stanzaConAttrezzo.getDescrizione(), "Ti trovi in: Stanza Con Attrezzo\nLe uscite della stanza sono:  sud nord\nNella stanza sono presenti i seguenti attrezzi: osso (1kg) lanterna (3kg) ");
	} 
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(stanzaConAttrezzo.hasAttrezzo("lanterna"));
		assertTrue(stanzaConAttrezzo.hasAttrezzo("osso"));
		assertFalse(stanzaVuota.hasAttrezzo("osso"));
		assertFalse(stanzaVuota.hasAttrezzo("lanterna"));
	}

	@Test
	public void testGetAttrezzo() {
		assertEquals(stanzaConAttrezzo.getAttrezzo("lanterna"), lanterna);
		assertEquals(stanzaConAttrezzo.getAttrezzo("osso"), osso);
		assertNull(stanzaVuota.getAttrezzo("osso"));
		assertNull(stanzaNulla.getAttrezzo("lanterna"));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		assertTrue(stanzaConAttrezzo.removeAttrezzo(lanterna));
		assertFalse(stanzaConAttrezzo.removeAttrezzo(pc));
		assertFalse(stanzaVuota.removeAttrezzo(accendino));
		assertTrue(stanzaPiena.removeAttrezzo(libro));
	}
	
	@Test
	public void testStanzaConPiuAttrezzi() {
		Stanza maggiore = this.stanzaConAttrezzo.stanzaConPiuAttrezzi();
		assertEquals(stanzaPiena, maggiore);
	}
	
	@Test
	public void testStanzaConMenoAttrezzi() {
		Stanza minore = this.stanzaConAttrezzo.stanzaConMenoAttrezzi();
		assertEquals(stanzaVuota, minore);
	}
}
