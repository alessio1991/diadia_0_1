package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Guarda cosa c'è nella stanza corrente e nella borsa
 */
public class ComandoGuarda implements Comando {
	private String messaggio;
	
	public String esegui(Partita partita) {
		this.messaggio = partita.getStanzaCorrente().getDescrizione()+"\n";
		this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
		return this.messaggio;
		}
}

