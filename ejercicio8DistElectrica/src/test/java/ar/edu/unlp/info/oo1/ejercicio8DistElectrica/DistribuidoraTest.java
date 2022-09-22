package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DistribuidoraTest {
	
	Distribuidora dist;
	Usuario usuario1,usuario2;
	Consumo consumo1,consumo2,consumo3;
	
	@BeforeEach
	void setUp() throws Exception {
		dist = new Distribuidora(10);
		consumo1 = new Consumo(LocalDate.parse("2021-01-28"),20,30); //fdp 0.55
		consumo2 = new Consumo(LocalDate.parse("2020-01-28"),20,10); //fdp 0.89
		usuario1 = new Usuario("calle 1", "juan");
		usuario2 = new Usuario("calle 50", "pedro");
	}

	@Test
	void testInicioSistema() {
		assertEquals(10, dist.precioKWh());
		assertEquals(0, dist.consumoTotalActiva());
	}

	@Test
	void testAgregarUsuario() {
		dist.agregarUsuario(usuario1);
		dist.agregarUsuario(usuario2);
		assertEquals(2, dist.getUsuarios().size());
	}
	
	@Test
	void testEmitirFacturas() {
		dist.agregarUsuario(usuario1);
		dist.agregarUsuario(usuario2);
		
		usuario1.agregarMedicion(consumo1); //200 
		usuario2.agregarMedicion(consumo2); //180
		
		double montoTotalFacturas = dist.facturar().stream().mapToDouble(factura -> factura.montoTotal()).sum();
		
		assertEquals(380, montoTotalFacturas);
	}
	
	@Test
	void calcularConsumoTotal(){
		
		assertEquals(0, dist.consumoTotalActiva());
		
		dist.agregarUsuario(usuario1);
		dist.agregarUsuario(usuario2);
		usuario1.agregarMedicion(consumo1); //20 
		usuario2.agregarMedicion(new Consumo(LocalDate.parse("2021-01-28"),30,0)); //30
		
		assertEquals(50, dist.consumoTotalActiva());
	}
}
