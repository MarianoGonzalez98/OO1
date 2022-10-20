package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	Sistema sistema1,sistemaVacio;
	Usuario usuario1,usuario2;
	Propiedad propiedad1;
	
	
	@BeforeEach
	void setUp() throws Exception {
		sistema1 = new Sistema();
		sistemaVacio=new Sistema();
		usuario1 = new Usuario("alberto", "calle 1", 1111);
		usuario2 = new Usuario("benito", "calle 2", 2222);
		propiedad1 = new Propiedad("Catedral", 100, "es hermosa", new CancelacionEstricta());
		
	}

	@Test
	void testRegistrarUsuarios() {

		assertEquals("alberto", usuario1.getNombre());
		assertEquals("calle 1", usuario1.getDireccion());
		assertEquals(1111, usuario1.getDni());
		
		assertTrue(sistema1.getUsuarios().contains(usuario1));
	}

	@Test
	void testRegistrarPropiedad() {
		assertTrue(usuario1.getPropiedades().contains(propiedad1));
		assertTrue(sistema1.getPropiedades().contains(propiedad1));
	}
	
	@Test
	void testHacerReserva() {
		Reserva reserva1 = sistema1.registrarReserva(propiedad1, new DateLapse("2022-01-01","2022-01-10"), usuario2);
		Reserva reserva2 = sistema1.registrarReserva(propiedad1, new DateLapse("2022-01-05","2022-01-15"), usuario2); //se superpone
		Reserva reserva3 = sistema1.registrarReserva(propiedad1, new DateLapse("2022-01-11","2022-01-14"), usuario2);
		
		assertTrue(usuario2.obtenerReservas().contains(reserva1));
		assertNull(reserva2);
		assertTrue(usuario2.obtenerReservas().contains(reserva3));
	}
	
	@Test
	void testPropiedadesDisponibles() {
		assertTrue(sistema1.propiedadesDisponibles(new DateLapse("2022-01-01","2022-12-31")).contains(propiedad1));
		Reserva reserva1 = sistema1.registrarReserva(propiedad1, new DateLapse("2022-01-01","2022-01-10"), usuario2);
		assertFalse(sistema1.propiedadesDisponibles(new DateLapse("2022-01-05","2022-12-31")).contains(propiedad1));
		assertFalse(sistema1.propiedadesDisponibles(new DateLapse("2022-01-10","2022-12-31")).contains(propiedad1));
		assertTrue(sistema1.propiedadesDisponibles(new DateLapse("2022-01-11","2022-12-31")).contains(propiedad1));
	}
	
}
