package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.FabbricaDiComandiSemplice;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
	
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private FabbricaDiComandiSemplice fabbrica;
	private Stanza stanzaCorrente;
	
	public Partita() {
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
		this.finita = false;
		this.fabbrica = new FabbricaDiComandiSemplice();
		this.stanzaCorrente = this.getLabirinto().getStanzaIniziale();
	}

    
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || !giocatoreIsVivo();
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * Metodo per verificare se il giocatore è ancora vivo (ha ancora CFU)
	 * @return true se ha ancora i CFU, false altrimenti
	 */
	public boolean giocatoreIsVivo() {
    	return (this.getGiocatore().getCfu() != 0);
    }
	
	public FabbricaDiComandiSemplice getFabbrica() {
		return this.fabbrica;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}
