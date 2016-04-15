package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Varie stampe nel caso in cui il comando non sia valido
 * @author diadia_futuri_ingegneri
 *
 */
public class ComandoNonValido implements Comando {
	private String parametro;
	private String messaggio;
	
	public ComandoNonValido(String parametro) {
		this.parametro = parametro;
	}
	
	public String esegui(Partita partita) {
		if (this.parametro == null)	
			this.messaggio = "Inserire il comando. Scrivere aiuto per conoscere i comandi...";
		else
			this.messaggio = "Il comando inserito non e' valido.\n";
		this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
		this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
		this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU\n";
		return this.messaggio;
	}
}
