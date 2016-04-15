package it.uniroma3.diadia.giocatore;


/**
 * Classe che crea un giocatore con CFU e una borsa
 * 
 * @author diadia_futuri_ingegneri
 *
 */
public class Giocatore {
	private int cfu;
	private static int CFU_INIZIALI = 20;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public int setCfu(int cfu) {
		return this.cfu=cfu;
	}
		
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	/**
	 * Modifica la borsa corrente
	 * @param borsaNuova la nuova borsa del giocatore
	 */
	public void setBorsa(Borsa borsaNuova) {
		this.borsa = borsaNuova;
	}
	
}
