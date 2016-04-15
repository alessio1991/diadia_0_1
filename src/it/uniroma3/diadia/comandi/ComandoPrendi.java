package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Prende l'attrezzo scelto dalla stanza, 
 * per poi metterlo nella borsa.
 */
public class ComandoPrendi implements Comando {
	private String attrezzoDaPrendere;
	private String messaggio;
	
	public ComandoPrendi(String attrezzoDaPrendere) {
		this.attrezzoDaPrendere = attrezzoDaPrendere;
		this.messaggio = "";
	}
	
	public String esegui(Partita partita) {
    	if (attrezzoDaPrendere == null)
    		this.messaggio = "Inserisci attrezzo da prendere.\n";
    	else if (!partita.getStanzaCorrente().hasAttrezzo(attrezzoDaPrendere))
    		this.messaggio = "L'attrezzo scelto non e' presente nella stanza.\n";
    	else if (partita.getGiocatore().getBorsa().entraAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere))) {
    			partita.getGiocatore().getBorsa().addAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere));
    			partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(attrezzoDaPrendere));
    		}
    	else {
    		this.messaggio = "La borsa è piena";
    	}
    	this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
    	this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
    	this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU\n";
    	return this.messaggio;
    }
}
