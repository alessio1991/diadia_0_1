package it.uniroma3.diadia.ambienti;

/**
 * Se nella stanza non � presente un attrezzo con un nome particolare (ad esempio "lanterna") 
 * il metodo getDescrizione() di una stanza buia ritorna la stringa "qui c'� un buio pesto"
 * @author Alessio
 *
 */
public class StanzaBuia extends Stanza {
	final static private String ATTREZZO_DEFAULT = "lanterna";
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_DEFAULT);
	}
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuminoso = attrezzo;
	}
	
	
	/**
	 * Restituisce la descrizione della stanza specificata
	 * se � presente l'ATTREZZO_DEFAULT,
	 * altrimenti dice di esserci un buio pesto!
	 */
	@Override
	public String getDescrizione() {	
	       if (this.hasAttrezzo(attrezzoLuminoso))
	           return (super.getDescrizione());
	       else 
	    	return ("Qui c'� un buio pesto!");
	}
}
