package ar.edu.unlp.info.oo1.ejercicio11Inversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	String nombre;
	List<Inversion> inversiones;
	
	
	public Inversor(String nombre) {
		this.nombre=nombre;
		inversiones = new ArrayList<>();
	}
	
	public double valorActual() {
		return inversiones.stream().mapToDouble(inversion -> inversion.valorActual()).sum();
	}
	
	public void agregarInversion(Inversion inversion) {
		inversiones.add(inversion);
	}
}
