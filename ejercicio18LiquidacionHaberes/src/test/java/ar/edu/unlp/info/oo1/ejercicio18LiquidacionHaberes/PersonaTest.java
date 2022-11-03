package ar.edu.unlp.info.oo1.ejercicio18LiquidacionHaberes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class PersonaTest {
	
	Persona james, guido;
	List<Persona> listaPersonas;
	List<String> lista ;
	
	@BeforeEach
	void setUp() throws Exception {
		listaPersonas = new ArrayList<>();
		
		james = new Persona();
		guido = new Persona();
		james.setApellido("Glosing");
		james.setNombre("James");
		guido.setApellido("van Rossum");
		guido.setNombre("Guido");
		
		james.lista.add("aaa");
		james.lista.add("abbb");
		james.lista.add("ccc");
		guido.lista.add("ddd");
		guido.lista.add("aeee");
		guido.lista.add("fff");
		
		listaPersonas.add(james);
		listaPersonas.add(guido);
		
		lista = listaPersonas.stream().map(p -> p.lista).flatMap(l -> l.stream()).filter(s -> s.startsWith("a")).toList();
		
		
	}
	
    @Test
    public void testNombreCompleto() {
        assertEquals("Glosing, James", james.getNombreCompleto());
        assertEquals("van Rossum, Guido", guido.getNombreCompleto());
        assertTrue(lista.contains("aaa"));
        assertTrue(lista.contains("abbb"));
        assertTrue(lista.contains("aeee"));
        assertFalse(lista.contains("fff"));
        assertFalse(lista.contains("ccc"));
    }
}
