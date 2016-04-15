package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Personaggio;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Crea il labirinto del gioco, con tutte le stanze e le porte di collegamento
 */
public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaMagica;
	public Labirinto() {
		init();
	}
	
	public void init() {
			/* crea gli attrezzi */
	    	Attrezzo lanterna = new Attrezzo("lanterna",3);
			Attrezzo osso = new Attrezzo("osso",1);
			Attrezzo lavagna = new Attrezzo("lavagna",5);		
			Attrezzo libro = new Attrezzo("libro",1);		
			Attrezzo pc = new Attrezzo("pc",2); 
			Attrezzo passepartout = new Attrezzo("passepartout", 1);
			Attrezzo spada = new Attrezzo("spada", 5);
			
			/* crea stanze del labirinto */
			StanzaBloccata atrio = new StanzaBloccata("Atrio");
			Stanza aulaN11 = new StanzaBuia("Aula N11");
			Stanza aulaN10 = new Stanza("Aula N10");
			Stanza laboratorio = new StanzaMagica("Laboratorio Campus");
			Stanza biblioteca = new Stanza("Biblioteca");
			
			//crea i personaggi
			Personaggio mago = new Mago("Merlino", "Sono un fenomeno di mago!", spada);
			Personaggio strega = new Strega("Ursula", "Sono una strega malefica");
			Personaggio cane = new Cane("Ringhio", "Bau bau!");
			
			/* collega le stanze */
			atrio.impostaUscita("nord", biblioteca);
			atrio.impostaUscita("est", aulaN11);
			atrio.impostaUscita("sud", aulaN10);
			atrio.impostaUscita("ovest", laboratorio);
			aulaN11.impostaUscita("est", laboratorio);
			aulaN11.impostaUscita("ovest", atrio);
			aulaN10.impostaUscita("nord", atrio);
			aulaN10.impostaUscita("est", aulaN11);
			aulaN10.impostaUscita("ovest", laboratorio);
			laboratorio.impostaUscita("est", atrio);
			laboratorio.impostaUscita("ovest", aulaN11);
			biblioteca.impostaUscita("sud", atrio);

	        /* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			atrio.addAttrezzo(osso);
			laboratorio.addAttrezzo(pc);		
			aulaN11.addAttrezzo(libro);		
			aulaN10.addAttrezzo(lavagna);
			laboratorio.addAttrezzo(passepartout);
			
			//aggiungo vari personaggi nelle stanze
			atrio.addPersonaggio(cane);
			aulaN10.addPersonaggio(strega);
			aulaN11.addPersonaggio(mago);
			
			// il gioco comincia nell'atrio
	        this.stanzaIniziale = atrio;  
			this.stanzaVincente = biblioteca;
			this.stanzaBloccata = atrio;
			this.stanzaMagica = laboratorio;
		}

		public StanzaBloccata getStanzaBloccata() {
			return this.stanzaBloccata;
		}
	
		public Stanza getStanzaVincente() {
			return this.stanzaVincente;
		}
		
		public Stanza getStanzaIniziale() {
			return this.stanzaIniziale;
		}
}
