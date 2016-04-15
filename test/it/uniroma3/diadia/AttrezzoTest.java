package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class AttrezzoTest {
	private Attrezzo attrezzoNomeNullo, attrezzoNormale, attrezzoPesoZero;

	@Before
	public void setUp() throws Exception {
		this.attrezzoNomeNullo = new Attrezzo(" ", 2);
		this.attrezzoNormale = new Attrezzo("osso", 3);
		this.attrezzoPesoZero = new Attrezzo("lanterna", 0);
	}

	@Test
	public void testGetNome() {
		assertEquals(attrezzoNomeNullo.getNome(), " ");
		assertEquals(attrezzoNormale.getNome(), "osso");
		assertEquals(attrezzoPesoZero.getNome(), "lanterna");		
	}

	@Test
	public void testGetPeso() {
		assertEquals(attrezzoNomeNullo.getPeso(), 2);
		assertEquals(attrezzoNormale.getPeso(), 3);
		assertEquals(attrezzoPesoZero.getPeso(), 0);
	}

	@Test
	public void testToString() {
		assertEquals(attrezzoNomeNullo.toString(), "  (2kg)");
		assertEquals(attrezzoNormale.toString(), "osso (3kg)");
		assertEquals(attrezzoPesoZero.toString(), "lanterna (0kg)");
		
	}

}
