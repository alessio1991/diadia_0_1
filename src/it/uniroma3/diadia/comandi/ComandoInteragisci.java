package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.Personaggio;

public class ComandoInteragisci implements Comando {
	private String messaggio;

	public String esegui(Partita partita) {
		Personaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		if(personaggio == null) {
			this.messaggio = "Con chi stai interagendo? Non c'è nessuno nella stanza!\n";
		} else {
			this.messaggio = personaggio.agisci(partita)+"\n";
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
