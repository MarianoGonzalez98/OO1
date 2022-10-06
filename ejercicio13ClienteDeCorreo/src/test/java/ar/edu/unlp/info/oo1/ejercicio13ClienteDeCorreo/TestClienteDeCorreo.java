package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClienteDeCorreo {
	ClienteDeCorreo correo1,correo2;
	Carpeta car1,car2;
	Email mail1, mail2, mail3, mail4;
	Archivo arc1,arc2,arc3,arc4;
	
	@BeforeEach
	void setUp() throws Exception {
		arc1=new Archivo("H");
		arc2=new Archivo("HO");
		arc3=new Archivo("HOLAS");
		arc4=new Archivo("HOLARDO");
		
		mail1=new Email("12345","123456"); //peso total: 14
		mail1.agregarAdjunto(arc1);
		mail1.agregarAdjunto(arc2);
		
		mail2=new Email("123","1ac"); //peso total: 11
		mail2.agregarAdjunto(arc3);
		
		mail3=new Email("123456789","");
		mail3.agregarAdjunto(arc4);
		
		mail4=new Email("1234","123");
		
		car1= new Carpeta("carpeta1");
		
		correo1= new ClienteDeCorreo("cliente1");
		correo1.recibir(mail1);
		correo1.recibir(mail2);
		correo1.agregarCarpeta(car1);
		correo1.mover(mail1, correo1.inbox(), car1);
	}

	@Test
	void testConstructor() {
		assertEquals(25, (int)Math.round(correo1.espacioOcupado()));
		assertEquals(mail2, correo1.buscar("ac"));
		assertEquals(mail1,correo1.buscar("45"));
	}

}
