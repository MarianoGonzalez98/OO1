package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCuentas {
	Cuenta cajaAhorro;
	Cuenta cuentaCorriente;
	@BeforeEach
	void setUp() throws Exception {
		cajaAhorro= new CajaDeAhorro();
		cuentaCorriente = new CuentaCorriente();
		
		cajaAhorro.depositar(200);
		cuentaCorriente.depositar(200);
	}

	@Test
	void testTransferencia() {
		cajaAhorro.transferirACuenta(100, cuentaCorriente);
		assertEquals(300, cuentaCorriente.getSaldo());
		assertEquals(94,cajaAhorro.getSaldo()); // +196 -98 = 94
	}

}
