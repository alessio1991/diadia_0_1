package it.uniroma3.diadia.giocatore;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
		public final static int DEFAULT_PESO_MAX_BORSA = 10;
		private Set<Attrezzo> attrezzi;
		private int pesoMax;

		public Borsa() {
			this(DEFAULT_PESO_MAX_BORSA);
		}

		public Borsa(int pesoMax) {
			this.pesoMax = pesoMax;
			this.attrezzi = new HashSet<Attrezzo>();

		}
		
		/**
	     * Colloca un attrezzo nella borsa.
	     * @param attrezzo l'attrezzo da collocare nella borsa.
	     *        Impostare a null per rappresentare l'assenza
	     *        di attrezzi nella borsa.
	     */
		public boolean addAttrezzo(Attrezzo attrezzo) {
			return this.attrezzi.add(attrezzo);
		}
		
		/**
	     * Restituisce il peso massimo della borsa.
	     * @return il peso massimo della borsa
	     */
		public int getPesoMax() {
			return pesoMax;
		}

		/**
	     * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
		 * @param nomeAttrezzo
		 * @return l'attrezzo presente nella borsa.
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
	     * Restituisce il peso della borsa.
	     * @return il peso della borsa
	     */
		public int getPeso() {
			int pesoTotale = 0;
		    for(Attrezzo a : this.attrezzi)
				pesoTotale += a.getPeso();
			  return pesoTotale;

		}

		public boolean isEmpty() {
			return this.attrezzi.isEmpty();
		}

		 /**
		  * Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
		  * @param nomeAttrezzo l'attrezzo da controllare
		  * @return true se l'attrezzo esiste nella borsa, false altrimenti.
		  */
		public boolean hasAttrezzo(String nomeAttrezzo) {
			return this.getAttrezzo(nomeAttrezzo) != null;
		}

		/**
		 * Rimuove un attrezzo dalla borsa.
		 * @param attrezzo da rimuovere
		 */
		public Attrezzo removeAttrezzo(String nomeAttrezzo) {
			Attrezzo a = null;
		    Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		    while (iteratore.hasNext()) {
		       a = iteratore.next();
		       if (a.getNome().equals(nomeAttrezzo)) {
				  iteratore.remove();
				  return a;
			   }
		    }
		  	 return null;
		}

		/**
	     * Restituisce la descrizione della borsa.
	     * @return la descrizione della borsa
	     */
		public String toString() {
			String s = new String();
	    		if (!this.isEmpty()) {
	    			s += "La borsa contiene i seguenti attrezzi: ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ";
	    			for (Attrezzo a: this.attrezzi)
	    				s += a.toString()+" ";
	    			}
	    		else 
	    			s += "La borsa e' vuota, non ha attrezzi al suo interno.";
	    		return s;
		}

		/**
	     * Restituisce vero se lo spazio nella borsa
	     * e' sufficiente a contenere l'attrezzo altrimenti
	     * restituisce falso
	     * @return true o false se l'attrezzo entra o no nella borsa
	     */
		public boolean entraAttrezzo (Attrezzo attrezzo) {
			if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
				return false;
			return true;
		}
}
