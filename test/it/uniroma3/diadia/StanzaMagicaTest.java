package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaMagicaTest {
	private Stanza stanzaMagicaSogliaSuperata, stanzaMagicaSogliaNonSuperata;
	private Attrezzo lanterna, osso, astuccio, telefono, tavolo, sedia;	
	@Before
	public void setUp() throws Exception {
		this.stanzaMagicaSogliaSuperata = new StanzaMagica("StanzaMagicaSogliaSuperata");
		this.stanzaMagicaSogliaNonSuperata = new StanzaMagica("StanzaMagicaSogliaNonSuperata");
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		this.astuccio = new Attrezzo("astuccio", 1);
		this.telefono = new Attrezzo("telefono", 2);
		this.tavolo = new Attrezzo("tavolo", 5);
		this.sedia = new Attrezzo("sedia", 3);
		this.stanzaMagicaSogliaSuperata.addAttrezzo(osso);
		this.stanzaMagicaSogliaSuperata.addAttrezzo(lanterna);
		this.stanzaMagicaSogliaSuperata.addAttrezzo(astuccio);
		this.stanzaMagicaSogliaNonSuperata.addAttrezzo(tavolo);
		this.stanzaMagicaSogliaNonSuperata.addAttrezzo(sedia);
	}
	

	@Test
	public void testAddAttrezzoStanzaSogliaNonSuperata() {
		assertTrue(this.stanzaMagicaSogliaNonSuperata.hasAttrezzo("sedia"));
		assertFalse(this.stanzaMagicaSogliaNonSuperata.hasAttrezzo("telefono"));
		this.stanzaMagicaSogliaNonSuperata.addAttrezzo(telefono);
		assertEquals(this.stanzaMagicaSogliaNonSuperata.getAttrezzo("telefono").getNome(), "telefono");
		assertEquals(this.stanzaMagicaSogliaNonSuperata.getAttrezzo("telefono").getPeso(), this.telefono.getPeso());
	}

	@Test
	public void testAddAttrezzoStanzaSogliaSuperata() {
		assertTrue(this.stanzaMagicaSogliaSuperata.hasAttrezzo("osso"));
		assertTrue(this.stanzaMagicaSogliaSuperata.hasAttrezzo("lanterna"));
		assertTrue(this.stanzaMagicaSogliaSuperata.hasAttrezzo("astuccio"));
		assertFalse(this.stanzaMagicaSogliaSuperata.hasAttrezzo("sedia"));
		this.stanzaMagicaSogliaSuperata.addAttrezzo(sedia);
		assertTrue(this.stanzaMagicaSogliaSuperata.hasAttrezzo("aides"));
		assertEquals(this.stanzaMagicaSogliaSuperata.getAttrezzo("aides").getPeso(), this.sedia.getPeso()*2);
	}
}
	
