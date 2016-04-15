package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaVincente;
	
	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.stanzaVincente = this.labirinto.getStanzaVincente();
		
	}	

	@Test
	public void testGetStanzaVincente() {
		assertEquals(this.labirinto.getStanzaVincente(), this.stanzaVincente);
		}
}
