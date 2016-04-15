package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Una stanza magica ha delle particolarità, che la rendono diversa dalla stanza ordinaria:
 * dopo N volte che da tale stanza viene posato un qualsiasi attrezzo dal giocatore, 
 * la stanza inizierà a comportarsi “magicamente” 
 * quando la stanza si comporta magicamente, ogni volta che posiamo un attrezzo, la stanza "inverte" il nome dell'attrezzo e ne raddoppia il peso. 
 * Ad esempio: se posiamo (togliamo dalla borsa e aggiungiamo alla stanza) l'attrezzo con nome "chiave" e peso 2, 
 * la stanza memorizza un attrezzo con nome "evaihc" e peso 4
 * quando la stanza non si comporta magicamente, il comportamento rimane quello usuale
 * @author Alessio
 *
 */
public class StanzaMagica extends Stanza {
	    final static private int SOGLIA_DEFAULT = 3;
	    private int contatoreAttrezziPrelevatiDaBorsa;
	    private int sogliaMagica;
	    
		  public StanzaMagica(String nome) {
			this(nome, SOGLIA_DEFAULT);
		  }
		  
	 	  public StanzaMagica(String nome, int soglia) {
	       super(nome);
	       this.contatoreAttrezziPrelevatiDaBorsa = 0;
	       this.sogliaMagica = soglia;
		  }
		   
	 	  
	 	/**
	 	 * Aggiunge l'attrezzo nella stanza magica,
	 	 * invertendo il nome e raddoppiandone il peso,
	 	 * se è stata superata la soglia magica
	 	 */
	 	@Override
	 	public void addAttrezzo(Attrezzo attrezzo) {
	 		this.contatoreAttrezziPrelevatiDaBorsa++;
	    	if (this.contatoreAttrezziPrelevatiDaBorsa > this.sogliaMagica) 
	            attrezzo = this.modificaAttrezzo(attrezzo);
	        super.addAttrezzo(attrezzo);
	    }
	    
	 	/**
	     * Inverte il nome dell'attrezzo e ne raddoppia il peso
	     * @param attrezzo l'attrezzo da modificare
	     * @return l'attrezzo con nome invertito, e peso doppio
	     */
	    public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
	    	StringBuffer nomeInvertito;
	        int pesoDoppio = attrezzo.getPeso()*2;
	        nomeInvertito  = new StringBuffer(attrezzo.getNome());
	        nomeInvertito = nomeInvertito.reverse();
	        attrezzo = new Attrezzo(nomeInvertito.toString(), pesoDoppio);
	        return attrezzo;
	    }
	    
	    
	    /**
	     * Metodo per restituite il valore intero della soglia magica
	     * @return il valore intero della sogliaMagica
	     */
	    public int getSoglia() {
	    	return this.sogliaMagica;
	    }
}
