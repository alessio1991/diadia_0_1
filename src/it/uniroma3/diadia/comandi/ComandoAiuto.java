package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private static String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "saluta", "interagisci", "regala", "aiuto", "fine"};	 
	private String messaggio;
	
	 /**
     * Stampa informazioni di aiuto.
     */
	public String esegui(Partita partita) {
		this.messaggio = "I comandi del gioco sono: ";
		for(int i=0; i<elencoComandi.length-1; i++) {
			this.messaggio += (elencoComandi[i]+", ");
		}
		this.messaggio += elencoComandi[elencoComandi.length-1] +".";
		System.out.println();
		return this.messaggio;
	}
}
