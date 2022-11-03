package ar.edu.unlp.info.oo1.ejercicio18LiquidacionHaberes;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Persona {

	private String nombre;
	private String apellido;
	private String dni;
	public List<String> lista;
	
	public Persona() {
		lista=new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Retorna el nombre completo de la persona de la forma apellido, nombre
	 * @return
	 */
	public String getNombreCompleto() {
		return this.getApellido() + ", " + this.getNombre();
	}

}
