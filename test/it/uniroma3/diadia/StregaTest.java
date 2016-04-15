package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Personaggio;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;


public class StregaTest {
	private Stanza stanzaConAttrezzo, stanzaVuota, stanzaPiena;
	private Attrezzo lanterna, osso, pc, libro, lavagna, accendino, banco, telefono, bottiglia, sedia;
	private Personaggio strega;
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.stanzaConAttrezzo = new Stanza("Stanza Con Attrezzo");
		this.stanzaVuota = new Stanza("Stanza Vuota");
		this.stanzaPiena = new Stanza("Stanza piena");
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
		this.stanzaPiena.impostaUscita("est", stanzaConAttrezzo);
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
		this.strega = new Strega("Ursula", "Piacere sono la strega malefica.");
		this.partita = new Partita();
	}

	@Test
	public void testAgisciSenzaSaluto() {
		strega.agisci(partita);
		assertEquals(stanzaConAttrezzo.stanzaConMenoAttrezzi(), stanzaVuota);
	}
	
	@Test
	public void testAgisciConSaluto() {
		strega.saluta();
		strega.agisci(partita);
		assertEquals(stanzaConAttrezzo.stanzaConPiuAttrezzi(), stanzaPiena);
	}

}
