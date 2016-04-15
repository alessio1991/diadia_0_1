package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoSaluta;
import it.uniroma3.diadia.personaggi.Personaggio;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;

public class ComandoSalutaTest {
	private Partita partita;
	private Personaggio strega;
	private Comando comandoSaluta;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		strega = new Strega("Ursula", "Sono una strega malefica");
		comandoSaluta = new ComandoSaluta();
		
	}

	@Test
	public void testEseguiSalutaPersonaggioPresente() {
		this.partita.getStanzaCorrente().addPersonaggio(strega);
		assertFalse(partita.getStanzaCorrente().getPersonaggio().haSalutato());
		this.comandoSaluta.esegui(partita);
		assertTrue(partita.getStanzaCorrente().getPersonaggio().haSalutato());
	}
	
	@Test
	public void testEseguiSalutaPersonaggioNonPresente() {
		assertNull(partita.getStanzaCorrente().getPersonaggio());
	}

}
