package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCajaDeAhorro {
	CajaDeAhorro cuenta, cuentaVacia;
	@BeforeEach
	void setUp() throws Exception {
		cuenta = new CajaDeAhorro();
		cuentaVacia = new CajaDeAhorro();
		cuenta.depositar(100);
	}

	@Test
	void testConstructor() {
		assertEquals(0, cuentaVacia.getSaldo());
	}
	
	@Test
	void testPuedeExtraer() {
		assertEquals(false, cuenta.puedeExtraer(100));
		assertEquals(false, cuenta.puedeExtraer(98));
		assertEquals(true, cuenta.puedeExtraer(96));
	}
	
	@Test
	void testDeposito() {
		assertEquals(98, cuenta.getSaldo());
	}
	
	@Test
	void testExtraccion() {
		cuenta.extraer(96);
		assertEquals(98 - 96 * 1.02 , cuenta.getSaldo());
	}

}
