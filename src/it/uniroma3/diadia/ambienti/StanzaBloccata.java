package it.uniroma3.diadia.ambienti;

/**
 * Una delle direzioni della stanza non può essere seguita 
 * a meno che nella stanza non sia presente un oggetto con un nome particolare 
 * (ad esempio "passepartout") 
 * @author Alessio
 *
 */
public class StanzaBloccata extends Stanza {
	final static private String ATTREZZO_DEFAULT = "passepartout";
	final static private String DIREZIONE_DEFAULT = "sud";
	private String attrezzoSblocca;
	private String direzioneBloccata;

	public StanzaBloccata(String nome) {
		this(nome,DIREZIONE_DEFAULT, ATTREZZO_DEFAULT);
	}
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSblocca) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSblocca = attrezzoSblocca;
	}
	
	
	/**
	 * Restituisce un riferimento alla stanza posta all'uscita specificata
	 * solo se nella stanza è presente l'ATTREZZO_DEFAULT
	 * o l'uscita è diversa dalla DIREZIONE_DEFAULT,
	 * altrimenti restituisce un riferimento alla stanza corrente
	 */
	@Override
	public Stanza getUscita(String direzione) {
		if (direzione != direzioneBloccata)
			return super.getUscita(direzione);
		if (direzione.equals(direzioneBloccata))
			if (this.hasAttrezzo(attrezzoSblocca))
				return super.getUscita(direzioneBloccata);
		return this;
	}
	
	/**
	 * Restituisce la descrizione della stanza
	 * solo se è presente ATTREZZO_DEFAULT
	 * altrimenti stampa un errore!
	 */
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoSblocca))
			return super.getDescrizione();
		return (super.getDescrizione()+"\nNon hai l'attrezzo " +attrezzoSblocca+ ". \nMi dispiace non puoi accedere nella stanza: " +super.getUscita(DIREZIONE_DEFAULT).getNome()+" posta nell'uscita "+DIREZIONE_DEFAULT+".");
	}
	
	public String getDirezioneBloccata() {
		return this.direzioneBloccata;
	}
	
	public String getAttrezzoSbloccante() {
		return this.attrezzoSblocca;
	}
}
