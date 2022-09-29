package ar.edu.unlp.info.oo1.ejercicio11Inversor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InversorTest {
	Inversor inversor;
	@BeforeEach
	void setUp() throws Exception {
		inversor = new Inversor("Juan");
		inversor.agregarInversion(new PlazoFijo("2022-09-18", 100, 5)); //162.88 con 10 dias
		inversor.agregarInversion(new InversionEnAcciones("juancito", 3, 10)); //30
	}

	@Test
	void test() {
		boolean result= 192 < inversor.valorActual() && inversor.valorActual() < 193;
		assertEquals(true,result);
	}

}
