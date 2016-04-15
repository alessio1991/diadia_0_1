package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {
	private Stanza stanzaConLanterna, stanzaSenzaLanterna;
	private Attrezzo lanterna, osso, astuccio;
	
	@Before
	public void setUp() throws Exception {
		this.stanzaConLanterna = new StanzaBuia("Stanza Luminosa");
		this.stanzaSenzaLanterna = new StanzaBuia("Stanza senza luce");
		this.lanterna = new Attrezzo("lanterna", 3);
		this.osso = new Attrezzo("osso", 1);
		this.astuccio = new Attrezzo("astuccio", 1);
		this.stanzaSenzaLanterna.addAttrezzo(osso);
		this.stanzaConLanterna.addAttrezzo(lanterna);
		this.stanzaConLanterna.addAttrezzo(astuccio);
		this.stanzaSenzaLanterna.addAttrezzo(astuccio);
		this.stanzaSenzaLanterna.addAttrezzo(osso);
	}

	@Test
	public void testGetDescrizione() {
		assertEquals(this.stanzaSenzaLanterna.getDescrizione(), "Qui c'è un buio pesto!");
		assertEquals(this.stanzaConLanterna.getDescrizione(), "Ti trovi in: Stanza Luminosa\nLe uscite della stanza sono: \nNella stanza sono presenti i seguenti attrezzi: astuccio (1kg) lanterna (3kg) ");
	}
}
