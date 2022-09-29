package ar.edu.unlp.info.oo1.ejercicio12VolumenSuperficie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestReporte {
	ReporteDeConstruccion reporteVacio, reporte;
	Pieza cilindro,esfera,prisma;
	
	@BeforeEach
	void setUp() throws Exception {
		reporteVacio = new ReporteDeConstruccion();
		reporte = new ReporteDeConstruccion();
		cilindro = new Cilindro("Hierro", "Rojo", 5, 10);//superficie = 471.23 volumen = 785.398
		esfera = new Esfera("Hierro", "Amarillo",5); //superficie: 314.159 Volumen: 523.599	
		reporte.agregarPieza(cilindro); 
		reporte.agregarPieza(cilindro);
		reporte.agregarPieza(esfera);
	}

	@Test
	void test() {
		assertEquals(942, (int) reporte.getSuperficieDeColor("Rojo"));
		assertEquals(0, reporte.getSuperficieDeColor("Verde"));
		assertEquals(0, reporteVacio.getSuperficieDeColor("Verde"));
		assertEquals(2094,(int) reporte.getVolumenDeMaterial("Hierro"));
	}

}
