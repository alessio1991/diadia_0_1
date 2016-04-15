package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 */
public class ComandoVai implements Comando {
	private String direzione;	
	private String messaggio;
	

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}

  public String esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;        
		if (direzione == null) {
			this.messaggio = "Dove vuoi andare? Scrivere nord, sud, est, ovest dopo il vai.\n";
			this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
			this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
			this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU"+"\n";
			return this.messaggio;        
		}
		prossimaStanza = stanzaCorrente.getUscita(this.direzione);
		if (prossimaStanza == null) {
			this.messaggio = "Direzione inesistente. Scrivere nord, sud, est, ovest dopo il vai.\n";
			this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
			this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
			this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU"+"\n";
			return this.messaggio;
	   }
		if (partita.getLabirinto().getStanzaBloccata().equals(partita.getStanzaCorrente()) && !stanzaCorrente.hasAttrezzo(partita.getLabirinto().getStanzaBloccata().getAttrezzoSbloccante())) {
			if (direzione.equals(partita.getLabirinto().getStanzaBloccata().getDirezioneBloccata())) {
				this.messaggio = "Ops! L'uscita è bloccata :("+"\n";
				this.messaggio += partita.getStanzaCorrente().getDescrizione()+"\n";
				this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
				this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU\n";
				return this.messaggio;
			}
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		this.messaggio = partita.getStanzaCorrente().getDescrizione()+"\n";
		this.messaggio += partita.getGiocatore().getBorsa().toString()+"\n";
		this.messaggio += "Ti sono rimasti: "+partita.getGiocatore().getCfu()+" CFU"+"\n";
		return this.messaggio;
	}
}
