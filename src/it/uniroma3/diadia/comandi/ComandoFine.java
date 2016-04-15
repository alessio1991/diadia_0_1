package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Comando "Fine".
 * Termina il gioco.
 */
public class ComandoFine implements Comando {
	private String messaggio;

	public String esegui(Partita partita) {
		this.messaggio = "Hai deciso di terminare il gioco. Grazie di aver giocato!";  // si desidera smettere
		partita.setFinita();
		return this.messaggio;
	}
}
