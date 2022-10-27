package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {

	Sistema sistema;
	Cliente clienteF1,clienteF2,clienteNull,clienteJ1;
	Llamada l1,l2,l3;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema=new Sistema();
		sistema.agregarTelefono("123");
		sistema.agregarTelefono("1234");
		sistema.agregarTelefono("12345");
		
		clienteF1=sistema.agregarClienteFisico("albert", "calle1", 41099);
		clienteF2=sistema.agregarClienteFisico("benito", "calle2", 51099564);
		clienteJ1=sistema.agregarClienteJuridico("Carrefour", "calle3", "20-61099", "empresa");
		clienteNull=sistema.agregarClienteJuridico("Didi", "calle4", "30-71099", "empresa");

		l1=sistema.registrarLlamadaLocal("2022-01-01", 10, 5, clienteF1.getTelefono(), clienteF2.getTelefono()); // 5 * 1= 5
		l2=sistema.registrarLlamadaInterUrbana("2022-01-10", 10, 20, clienteF2.getTelefono(), clienteJ1.getTelefono(),200); //2.5 * 20 + 5= 55 
		l3=sistema.registrarLlamadaInternacional("2022-01-07", 10, 10, clienteF1.getTelefono(), clienteF2.getTelefono(),"Arg","Suecia"); // 4 * 10=40
	}

	@Test
	void testFacturarLlamadas() {
		Factura factura = clienteF2.facturarLlamadas("2021-12-25", "2022-01-15");
		assertEquals(49.5,factura.getMontoTotal());
		
		Factura factura3 = clienteF2.facturarLlamadas("2023-12-25", "2024-01-15");
		assertEquals(0,factura3.getMontoTotal());
		
		Factura factura2 = clienteF1.facturarLlamadas("2021-12-25", "2022-01-15");
		assertEquals(40.5,factura2.getMontoTotal());
	}
	
	
	@Test
	void testAltaCliente() {
		assertEquals(null,clienteNull);
		
		assertEquals(clienteF1,sistema.obtenerCliente(clienteF1.getTelefono()));
		assertEquals(clienteF2,sistema.obtenerCliente(clienteF2.getTelefono()));
		assertEquals(clienteJ1,sistema.obtenerCliente(clienteJ1.getTelefono()));
	}

}
