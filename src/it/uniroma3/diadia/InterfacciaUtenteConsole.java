package it.uniroma3.diadia;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {
	private String istruzione; 
    private Scanner scannerDiLinee;
    private Partita partita;
  
	public InterfacciaUtenteConsole() {
		scannerDiLinee = new Scanner(System.in);
		partita = new Partita();
		
	}
    public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
		if (this.partita.vinta())
			System.out.println("Complimenti! Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Mi dispiace, ma purtroppo hai esaurito i CFU. La partita è terminata. Grazie di aver giocato.");
	}
	
	public String prendiIstruzione() {
		istruzione = scannerDiLinee.nextLine();
	    return istruzione;
	}
	
	public Partita getPartita() {
		return this.partita;
	}
}
