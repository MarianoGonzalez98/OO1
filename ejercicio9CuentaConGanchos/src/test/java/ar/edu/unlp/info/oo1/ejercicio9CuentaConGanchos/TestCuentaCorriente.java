package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCuentaCorriente {
	CuentaCorriente cuentaVacia, cuenta;
	
	@BeforeEach
	void setUp() throws Exception {
		cuentaVacia = new CuentaCorriente();
		cuenta= new CuentaCorriente();
		cuenta.depositar(100);
		cuenta.setDescubierto(200);
		
	}

	@Test
	void testConstructor() {
		assertEquals(0, cuentaVacia.getDescubierto());
	}

	@Test
	void testSaldo() {
		assertEquals(100, cuenta.getSaldo());
		cuenta.extraer(150);
		assertEquals(-50, cuenta.getSaldo());
	}

	@Test
	void testPuedeExtraer() {
		assertEquals(true,cuenta.puedeExtraer(300));
	}

	@Test
	void testNoPuedeExtraer() {
		assertEquals(false,cuenta.puedeExtraer(301));
	}
}
