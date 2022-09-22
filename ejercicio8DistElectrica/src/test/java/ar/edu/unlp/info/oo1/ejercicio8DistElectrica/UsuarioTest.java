package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

	private Usuario usuario1;
	//private Consumo consumo1, consumo2, consumo3, consumo4, consumo5;
	@BeforeEach
	void setUp() throws Exception {
		usuario1 = new Usuario("calle 50", "mariano");
	}

	@Test
	void testAgregarConsumo() {
		Consumo consumo = new Consumo(LocalDate.parse("2018-01-28"),10,0);
		usuario1.agregarMedicion(consumo);
		
		assertEquals(consumo, usuario1.ultimoConsumo());
	}
	
	@Test
	void testUltimoConsumoActiva() {

		Consumo consumo1= new Consumo(LocalDate.parse("2018-01-28"),10,0);
		Consumo consumo2= new Consumo(LocalDate.parse("2019-01-28"),20,0);
		Consumo consumo3= new Consumo(LocalDate.parse("2020-01-28"),15,0);
		Consumo consumo4= new Consumo(LocalDate.parse("2016-01-28"),30,0);
		Consumo consumo5= new Consumo(LocalDate.parse("2019-02-28"),40,0);
		
		usuario1.agregarMedicion(consumo2);
		usuario1.agregarMedicion(consumo1);
		usuario1.agregarMedicion(consumo3);
		usuario1.agregarMedicion(consumo5);
		usuario1.agregarMedicion(consumo4);
		
		assertEquals(15, usuario1.ultimoConsumoActiva());
	}
	
	@Test 
	void testFacturarSinConsumo(){
		assertEquals(0,usuario1.facturarEnBaseA(10).montoTotal());
	}
	
	@Test
	void testFacturarSinDescuento() {
		Consumo consumo= new Consumo(LocalDate.parse("2021-01-28"),20,30); //fdp 0.55
		usuario1.agregarMedicion(consumo);
		assertEquals(200, usuario1.facturarEnBaseA(10).montoTotal());
	}
	
	@Test
	void testFacturarConDescuento() {
		Consumo consumo= new Consumo(LocalDate.parse("2020-01-28"),20,10); //fdp 0.89
		usuario1.agregarMedicion(consumo);
		assertEquals(180, usuario1.facturarEnBaseA(10).montoTotal());
	}

}
