package it.uniroma3.diadia.comandi;

/**
 * Crea un'interfaccia per la creazione di oggetti comando *
 */
public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione);
}
