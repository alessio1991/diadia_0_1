package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Personaggio;

import org.junit.Before;
import org.junit.Test;

public class MagoTest {
	private Partita partita;
	private Personaggio mago;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzo = new Attrezzo("spada", 5);
		mago = new Mago("Merlino", "Abracadabra", attrezzo);
	}

	@Test
	public void testAgisciPrimaVolta() {
		String msg = mago.agisci(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
		assertEquals(msg, "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo bel borsone!");
	}
	
	@Test
	public void testAgisciSecondaVolta() {
		mago.agisci(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
		String msg = mago.agisci(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("spada"));
		assertEquals(msg, "Mi spiace, ma non ho piu' nulla da darti ...");
	}

}
