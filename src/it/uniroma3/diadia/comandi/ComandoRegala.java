package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Personaggio;

public class ComandoRegala implements Comando {
	private String messaggio;
	private String attrezzoDaRegalare;
	
	public ComandoRegala(String attrezzoDaRegalare) {
		this.attrezzoDaRegalare = attrezzoDaRegalare;
	}
	
	public String esegui(Partita partita) {
		Personaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (attrezzoDaRegalare == null) {
			this.messaggio = "Scrivere dopo regala, uno degli attrezzi presente in borsa.";
		} else if (!(partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzoDaRegalare))) {
			 this.messaggio = "L'attrezzo non è presente in borsa.";
		} else if (personaggio == null) {
			 this.messaggio = "Non c'è nessuno nella stanza!";
		} else {
			this.messaggio = personaggio.riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaRegalare), partita);
		}
		return this.messaggio;
	}

	public String getErrore() {
		return null;
	}

	public String getMessaggio() {
		return this.messaggio;
	}

	public void setParametro(String parametro) {
	}

}


