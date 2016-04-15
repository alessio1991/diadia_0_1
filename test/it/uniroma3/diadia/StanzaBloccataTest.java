package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	private Stanza stanzaBloccata, stanzaNonBloccata, stanza;
	private Attrezzo attrezzoSbloccante, attrezzo;

	@Before
	public void setUp() throws Exception {
		this.stanzaBloccata = new StanzaBloccata("Stanza bloccata");
		this.stanzaNonBloccata = new StanzaBloccata("Stanza non bloccata");
		this.stanza = new StanzaBloccata("Stanza");
		this.attrezzo = new Attrezzo("osso", 3);
		this.attrezzoSbloccante = new Attrezzo("passepartout", 10);
		this.stanzaBloccata.addAttrezzo(attrezzo);
		this.stanzaNonBloccata.addAttrezzo(attrezzoSbloccante);
		this.stanzaNonBloccata.impostaUscita("sud", stanzaBloccata);
		this.stanzaNonBloccata.impostaUscita("est", stanza);
		this.stanzaBloccata.impostaUscita("sud", stanza);
		this.stanzaBloccata.impostaUscita("nord", stanzaNonBloccata);
		this.stanza.impostaUscita("nord", stanzaBloccata);
		this.stanza.impostaUscita("ovest", stanzaNonBloccata);
	}

	@Test
	public void testGetUscitaStanzaBloccata() {
		assertTrue(this.stanzaBloccata.hasAttrezzo("osso"));
		assertFalse(this.stanzaBloccata.hasAttrezzo("passepartout"));
		assertSame(this.stanzaBloccata.getUscita("nord"), this.stanzaNonBloccata);
		assertSame(this.stanzaBloccata.getUscita("sud"), this.stanzaBloccata);
	}
	
	public void testGetUscitaStanzaNonBloccata() {
		assertTrue(this.stanzaNonBloccata.hasAttrezzo("passepartout"));
		assertSame(this.stanzaNonBloccata.getUscita("sud"), this.stanzaBloccata);
		assertSame(this.stanzaNonBloccata.getUscita("est"), this.stanza);
	}

}
