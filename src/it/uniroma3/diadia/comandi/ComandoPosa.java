package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Prende l'attrezzo scelto dalla borsa, 
 * per poi metterlo nella stanza.
 */	
public class ComandoPosa implements Comando {
	private String attrezzoDaPosare;
	private String messaggio;
	
	public ComandoPosa(String attrezzoDaPosare) {
		this.attrezzoDaPosare = attrezzoDaPosare;
		this.messaggio = "";
	}
			
	public String esegui(Partita partita) {
		if (attrezzoDaPosare==null)
			this.messaggio = "Inserisci attrezzo posare.\n";
    	else if (!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzoDaPosare))
    		this.messaggio = "L'attrezzo scelto non e' presente nella borsa.\n";
    	else {
    		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaPosare));
    		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaPosare) ;
    	}
		this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
    	this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
    	this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU\n";
    	return this.messaggio;
	}
}
