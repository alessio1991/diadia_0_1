package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Personaggio;

import org.junit.Before;
import org.junit.Test;

public class CaneTest {
	private Partita partita;
	private Personaggio cane;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		cane = new Cane("Ringhio", "Bau bau");
	}

	@Test
	public void testAgisci() {
		int cfu = partita.getGiocatore().getCfu();
		cane.agisci(partita);
		assertEquals(cfu-1, partita.getGiocatore().getCfu());
	}

}
