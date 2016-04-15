package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Personaggio;

public class ComandoSaluta implements Comando {
	private String messaggio;
	
	public String esegui(Partita partita) {
		Personaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio == null) {
			this.messaggio = "Chi saluti? Non c'è nessuno nella stanza!";
		} else {
			this.messaggio = personaggio.saluta();
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
