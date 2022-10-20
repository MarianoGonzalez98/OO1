package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	Propiedad propiedad1,propiedad2,propiedad3;
	@BeforeEach
	void setUp() throws Exception {
		propiedad1= new Propiedad("Catedral", 100, "esta vieja", new CancelacionFlexible());
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
