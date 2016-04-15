package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	private Borsa borsaVuota;
	private Borsa borsaPiena;
	private Borsa borsaConAttrezzi;
	private Attrezzo lanterna, libro, lavagna, accendino, telefono, bottiglia;
	
	@Before
	public void setUp() throws Exception {
		this.lanterna = new Attrezzo("lanterna", 3);
		this.accendino = new Attrezzo("accendino", 3);
		this.bottiglia = new Attrezzo("bottiglia", 1);
		this.lavagna = new Attrezzo("lavagna", 10);
		this.libro = new Attrezzo("libro", 3);
		this.telefono = new Attrezzo("telefono", 2);
		borsaVuota=new Borsa();
		borsaPiena=new Borsa();
		borsaPiena.addAttrezzo(accendino);
		borsaPiena.addAttrezzo(lanterna);
		borsaPiena.addAttrezzo(bottiglia);
		borsaPiena.addAttrezzo(libro);
		borsaConAttrezzi=new Borsa();
		borsaConAttrezzi.addAttrezzo(bottiglia);
		borsaConAttrezzi.addAttrezzo(telefono);
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(borsaVuota.getPesoMax(), 10);
	}

	@Test
	public void testGetAttrezzo() {
		assertEquals(borsaConAttrezzi.getAttrezzo("telefono"), telefono);
		assertNull("lavagna", borsaVuota.getAttrezzo("lavagna"));
		assertNull(borsaPiena.getAttrezzo("lavagna"));
	}

	@Test
	public void testGetPeso() {
		assertEquals(borsaVuota.getPeso(), 0);
		assertEquals(borsaPiena.getPeso(), 10);
		assertEquals(borsaConAttrezzi.getPeso(), 3);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(borsaVuota.isEmpty());
		assertFalse(borsaPiena.isEmpty());
		assertFalse(borsaConAttrezzi.isEmpty());
	}

	@Test
	public void testHasAttrezzo() {
		assertTrue(borsaPiena.hasAttrezzo("libro"));
		assertFalse(borsaPiena.hasAttrezzo("telefono"));
		assertFalse(borsaVuota.hasAttrezzo("telefono"));
		assertTrue(borsaConAttrezzi.hasAttrezzo("bottiglia"));
		assertFalse(borsaConAttrezzi.hasAttrezzo("lanterna"));
	}

	@Test
	public void testRemoveAttrezzo() {
		borsaConAttrezzi.removeAttrezzo("telefono");
		assertFalse(borsaConAttrezzi.hasAttrezzo("telefono"));
		borsaVuota.removeAttrezzo("banco");
		assertFalse(borsaVuota.hasAttrezzo("banco"));
		borsaPiena.removeAttrezzo("bottiglia");
		assertFalse(borsaPiena.hasAttrezzo("bottiglia"));
	}

	@Test
	public void testEntraAttrezzo() {
		assertFalse(borsaPiena.entraAttrezzo(accendino));
		assertTrue(borsaVuota.entraAttrezzo(lavagna));
		assertFalse(borsaConAttrezzi.entraAttrezzo(lavagna));
		assertTrue(borsaConAttrezzi.entraAttrezzo(accendino));
	}
}
