package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoRegala;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Personaggio;
import it.uniroma3.diadia.personaggi.Strega;

import org.junit.Before;
import org.junit.Test;

public class ComandoRegalaTest {
	private Partita partita;
	private Personaggio mago, strega, cane;
	private Attrezzo attrezzo, attrezzoDaRegalare, attrezzoNonPiaceAlCane;
	private Comando comandoRegala, comandoRegala2;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("spada", 5);
		this.attrezzoDaRegalare = new Attrezzo("osso", 2);
		this.attrezzoNonPiaceAlCane = new Attrezzo("cipolla", 10);
		this.mago = new Mago("Merlino", "Sono un mago", attrezzo);
		this.strega = new Strega("Ursula", "Sono una strega malefica");
		this.cane = new Cane("Ringhio", "Bau bau!");
		this.comandoRegala = new ComandoRegala(attrezzoDaRegalare.getNome());
		this.comandoRegala2 = new ComandoRegala(attrezzoNonPiaceAlCane.getNome());
		this.stanza = new Stanza("Stanza");
	}

	@Test
	public void testRegalaMago() {
		this.partita.setStanzaCorrente(stanza);
		this.partita.getStanzaCorrente().addPersonaggio(mago);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaRegalare);
		this.comandoRegala.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaRegalare.getNome()));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoDaRegalare.getNome()));
		this.mago.agisci(partita);
		this.comandoRegala.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaRegalare.getNome()));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoDaRegalare.getNome()));
		assertEquals(this.partita.getStanzaCorrente().getAttrezzo(attrezzoDaRegalare.getNome()).getPeso(), attrezzoDaRegalare.getPeso()/2);
	}
	
	@Test
	public void testRegalaStrega() {
		this.partita.setStanzaCorrente(stanza);
		this.partita.getStanzaCorrente().addPersonaggio(strega);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaRegalare);
		this.comandoRegala.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaRegalare.getNome()));
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoNonPiaceAlCane);
		this.comandoRegala2.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoNonPiaceAlCane.getNome()));
	}
	
	@Test
	public void testRegalaCane() {
		this.partita.setStanzaCorrente(stanza);
		this.partita.getStanzaCorrente().addPersonaggio(cane);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoNonPiaceAlCane);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaRegalare);
		this.comandoRegala2.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoNonPiaceAlCane.getNome()));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoNonPiaceAlCane.getNome()));
		this.comandoRegala.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaRegalare.getNome()));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo(attrezzoDaRegalare.getNome()));
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("palla"));
	}
}
