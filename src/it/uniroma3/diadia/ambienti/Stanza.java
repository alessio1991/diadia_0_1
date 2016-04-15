package it.uniroma3.diadia.ambienti;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Personaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * @author Paolo Merialdo (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.1
*/

public class Stanza {
	private String descrizione;
	private Set<Attrezzo> attrezzi;
	private Map<String,Stanza> uscite;
	private Personaggio personaggio;


    /**
     * Crea una stanza. Inizialmente non ci sono uscite.
     * @param descrizione il nome della stanza
     */
    public Stanza(String descrizione) {
    	this.uscite = new HashMap<String,Stanza>();
    	this.attrezzi = new HashSet<Attrezzo>();
    	this.descrizione = descrizione;
    }
    
    /**
     * Imposta le uscite della stanza. Ogni direzione porta ad un'altra stanza.
     *
     * @param direzione direzione in cui sara' posta la stanza.
     * @param stanzaAdiacente stanza da collegare alla stanza corrente tramite l'uscita
     * indicata in direzione.
     */
    public void impostaUscita(String direzione, Stanza stanzaAdiacente) {
    	this.uscite.put(direzione,stanzaAdiacente);
    }

    /**
     * Restituisce la stanza dell'uscita specificata
     * @param direzione
     */
	public Stanza getUscita(String direzione) {
		return this.uscite.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.descrizione;
    }
	
    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }


    /**
     * Colloca un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da collocare nella stanza.
     *        Impostare a null per rappresentare l'assenza
     *        di attrezzi nella stanza.
     */
    public void addAttrezzo(Attrezzo attrezzo) {
    	if (attrezzo != null)
    		this.attrezzi.add(attrezzo);
    }
    
    /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	String s = new String();
    	s += "Ti trovi in: "+this.descrizione;
    	s += "\nLe uscite della stanza sono: ";
    	for (String uscite: this.uscite.keySet()) {
    		if (uscite!=null)
    			s += " " + uscite;
    	}
    	if (!isEmpty()) {
    		s += "\nNella stanza sono presenti i seguenti attrezzi: ";
    		for(Attrezzo attrezzi: this.attrezzi) {
    			if (this.attrezzi != null) {
    				s += attrezzi.toString()+" ";
    	    	}
    		} 
    	} else
    		s+= "\nLa stanza e' vuota, non ci sono attrezzi.";	
    	if (this.personaggio != null) {
    		s+="\nNella stanza è presente "+this.personaggio.getNome()+".";
    	} else {
    		s+="\nNella stanza non sono presenti personaggi.";
    	}
    	return s;
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @param attrezzo l'attrezzo da controllare se è presente
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String attrezzo) {
		if (attrezzo != null) 
			return this.attrezzi.contains(this.getAttrezzo(attrezzo));
		return false;	
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
		    a = iteratore.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}
			

	/**
	 * Rimuove un attrezzo dalla stanza.
	 * @param attrezzo l'attrezzo da rimuovere
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean rimosso = false;
		if (this.attrezzi.contains(attrezzo)) {
			this.attrezzi.remove(attrezzo);
			rimosso = true;
		}
		return 	rimosso;
	}	
	
	/**
	 * Restituisce il numero degli attrezzi nella stanza
	 * @return numero degli attrezzi
	 */
	public int numeroAttrezzi() {
		return this.attrezzi.size();
	}
	
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	
	public void setPersonaggio(Personaggio personaggio) {
		this.personaggio = personaggio;	
	}

	public Personaggio getPersonaggio() {
		return this.personaggio;	
	}
	
	
	/**
	 * Calcola la stanza adiacente con più attrezzi
	 * @return la stanza adiacente con più attrezzi
	 */
	public Stanza stanzaConPiuAttrezzi() {
		String a;
		Stanza maggiore = null;
		Set<String> direzioni = this.uscite.keySet();
		Iterator<String> iteratore = direzioni.iterator();
		if(iteratore.hasNext()) {
			maggiore = this.getUscita(iteratore.next());
			while (iteratore.hasNext()) {
				a = iteratore.next();
				if(maggiore.numeroAttrezzi() <= this.getUscita(a).numeroAttrezzi())
					maggiore = this.getUscita(a);
			}
		}
			return maggiore;
	}
	
	
	/**
	 * Calcola la stanza adiacente con meno attrezzi
	 * @return la stanza adiacente con meno attrezzi
	 */
	public Stanza stanzaConMenoAttrezzi() {
		String a;
		Stanza minore = null;
		Set<String> direzioni = this.uscite.keySet();
		Iterator<String> iteratore = direzioni.iterator();
		if(iteratore.hasNext()) {
			minore = this.getUscita(iteratore.next());
			while (iteratore.hasNext()) {
				a = iteratore.next();
				if(minore.numeroAttrezzi() >= this.getUscita(a).numeroAttrezzi())
					minore = this.getUscita(a);
			}
		}
			return minore;
	}
	
	
	/**
	 * Aggiunge un personaggio nella stanza
	 * @param personaggio il personaggio da aggiungere nella stanza
	 */
	public void addPersonaggio(Personaggio personaggio) {
		if(personaggio != null)
			this.personaggio = personaggio;
	}
	
	
	/**
	 * Verifica se è presente un personaggio
	 * @param nomePersonaggio il personaggio da verificare se presente
	 * @return true se è presente, false altrimenti
	 */
	public boolean hasPersonaggio(String nomePersonaggio) {
		if(nomePersonaggio != null)
			if(this.personaggio.getNome().equals(nomePersonaggio))
				return true;
		return false;
	}
	
}