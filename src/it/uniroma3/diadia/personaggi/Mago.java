package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends Personaggio {
		private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo bel borsone!";
		private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla da darti ...";

		private Attrezzo attrezzo;

		public Mago(String nome, String presentazione, Attrezzo attrezzo) {
			super(nome, presentazione);
			this.attrezzo = attrezzo;
		}

		public String agisci(Partita partita) {
			String msg;
			if (attrezzo!=null) {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				this.attrezzo = null;
				msg = MESSAGGIO_DONO;
			}
			else {
				msg = MESSAGGIO_SCUSE;
			}
			return msg;
		}
		
		public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
			String msg;
			Attrezzo attrezzoMezzi = null;
			if (this.attrezzo == null) { 
				attrezzoMezzi = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
				partita.getStanzaCorrente().addAttrezzo(attrezzoMezzi);
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
				msg = "Ora la tua borsa sarà più leggera!";
			} else {
				msg = "Mi dispiace...ma non posso ricevere altri oggetti :(";
			}
			return msg;
		}
}
