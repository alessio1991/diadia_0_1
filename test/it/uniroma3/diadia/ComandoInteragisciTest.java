package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoInteragisci;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Personaggio;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;

public class ComandoInteragisciTest {
	private Partita partita;
	private Personaggio mago, strega, cane;
	private Attrezzo attrezzo;
	private Comando comandoInteragisci;
	private Stanza stanzaConAttrezzo, stanzaVuota, stanzaPiena;
	private Attrezzo lanterna, osso, pc, libro, lavagna, accendino, banco, telefono, bottiglia, sedia;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("spada", 5);
		this.mago = new Mago("Merlino", "Sono un mago", attrezzo);
		this.cane = new Cane("Ringhio", "Bau bau");
		this.strega = new Strega("Strega", "Sono la strega");
		this.comandoInteragisci = new ComandoInteragisci();
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
	}

	@Test
	public void testEseguiMago() {
		partita.getStanzaCorrente().addPersonaggio(mago);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
		this.comandoInteragisci.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
	}

	@Test
	public void testEseguiCane() {
		int cfu = partita.getGiocatore().getCfu();
		partita.getStanzaCorrente().addPersonaggio(cane);
		assertEquals(partita.getGiocatore().getCfu(), cfu);
		this.comandoInteragisci.esegui(partita);
		assertEquals(partita.getGiocatore().getCfu(), cfu-1);
	}
	
	@Test
	public void testEseguiStregaSalutata() {
		Stanza stanza = this.partita.getStanzaCorrente();
		stanza.addPersonaggio(strega);
		partita.getStanzaCorrente().getPersonaggio().saluta();
		this.comandoInteragisci.esegui(partita);
		assertEquals(partita.getStanzaCorrente(), stanza.stanzaConPiuAttrezzi());
	}
	
	@Test
	public void testEseguiStregaNonSalutata() {
		Stanza stanza = this.partita.getStanzaCorrente();
		stanza.addPersonaggio(strega);
		this.comandoInteragisci.esegui(partita);
		assertEquals(partita.getStanzaCorrente(), stanza.stanzaConMenoAttrezzi());
	}
}
