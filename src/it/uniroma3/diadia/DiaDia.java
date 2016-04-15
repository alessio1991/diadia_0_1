package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiSemplice;


/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public class DiaDia {
	private InterfacciaUtente interfaccia;
	private static final String MESSAGGIO_BENVENUTO = 
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi metterli nella borsa, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'. \n\n"+
			"Ti trovi nell'Atrio, le uscite sono: nord, sud, est, ovest.\nOggetti presenti: osso (1 Kg)\n\n";
	
    public DiaDia() {
    	this.interfaccia = new InterfacciaUtenteConsole();
    }
    
    /**
     * Metodo che processa l'istruzione da eseguire
     * @param istruzione l'istruzione da eseguire
     * @return true se la partita non è anocora eseguita false altrimenti
     */
    private boolean processaIstruzione(String istruzione) {
    	Comando comandoDaEseguire;
        FabbricaDiComandiSemplice factory = new FabbricaDiComandiSemplice();
    	comandoDaEseguire = factory.costruisciComando(istruzione);
    	interfaccia.mostraMessaggio(comandoDaEseguire.esegui(this.interfaccia.getPartita())); 
    	return this.interfaccia.getPartita().isFinita();
    }

	public void gioca() {	
		String istruzione;
		System.out.println(MESSAGGIO_BENVENUTO);
		do		
			istruzione = interfaccia.prendiIstruzione();
		while (!processaIstruzione(istruzione));
	}   
	
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	} 
}