package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Strega extends Personaggio {
	private static final String MESSAGGIO_BUONO = "Grazie sei molto gentile...Ecco a te una ricompensa!";
	private static final String MESSAGGIO_CATTIVO = "Mi spiace, non mi hai salutato, ti punisco!";
	private Attrezzo attrezzo;
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
		this.attrezzo = null;
	}

	public String agisci(Partita partita) {
		String msg;
		if(this.haSalutato()) {
			partita.setStanzaCorrente(partita.getStanzaCorrente().stanzaConPiuAttrezzi());
			msg = MESSAGGIO_BUONO;
		} else {
			partita.setStanzaCorrente(partita.getStanzaCorrente().stanzaConMenoAttrezzi());
			msg = MESSAGGIO_CATTIVO;
		}
		return msg;
	}

	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg;
		if (this.attrezzo == null) {
			this.attrezzo = attrezzo;
			msg = "Muhahahaha!";
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		} else {
			msg = "Non ci faccio niente con altri attrezzi!";
		}
		return msg;
	}
}
