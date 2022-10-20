package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	Usuario usuario1,usuario2;
	Propiedad propiedad1;
	Reserva reserva1;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario1 = new Usuario("alberto", "calle 1", 1111);
		usuario2 = new Usuario("benito", "calle 2", 2222);
		propiedad1 = new Propiedad("Catedral", 100, "es hermosa", new CancelacionModerada());
		reserva1= new Reserva(new DateLapse("2022-01-01","2022-01-10"),propiedad1,usuario1);
		
	}

	@Test
	void testPrecio() {
		assertEquals(1000,(int)reserva1.precio());
	}
	
	@Test
	void testReembolso() {
		assertEquals(500,(int)reserva1.calcularReembolso(LocalDate.parse("2021-12-28")));
	}

}
