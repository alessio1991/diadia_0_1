package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends Personaggio {
	private Attrezzo attrezzo;
	private final static String CIBO_PREFERITO = "osso";
	private final static Attrezzo ATTREZZO_POSSEDUTO_DAL_CANE = new Attrezzo("palla", 1);

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
		this.attrezzo = null;
	}
	
	public String agisci(Partita partita) {
		String msg;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		msg = "Il cane ti ha morso. Adesso hai "+partita.getGiocatore().getCfu()+" CFU!";
		return msg;
	}
	
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if (this.attrezzo == null) {
			if (attrezzo.getNome().equals(CIBO_PREFERITO)) {
				this.attrezzo = attrezzo;
				partita.getStanzaCorrente().addAttrezzo(ATTREZZO_POSSEDUTO_DAL_CANE);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
				msg = "Veramente delizioso! Ho lasciato un regalo nella stanza! Bau bau!";
			} else {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
				msg = "Non so che farmene! Bau bau!";
			}
		} else {
			msg = "Mi dispiace non posso ricevere altri attrezzi...Bau bau.";
		}
		return msg;
	}
	
	
}