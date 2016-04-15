package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa interfaccia modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public interface Comando {
	/**
	    * esecuzione del comando
	 * @return 
	    */
	public String esegui(Partita partita);
}