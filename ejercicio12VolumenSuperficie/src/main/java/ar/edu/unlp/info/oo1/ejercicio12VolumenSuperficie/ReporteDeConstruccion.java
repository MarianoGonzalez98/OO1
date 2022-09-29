package ar.edu.unlp.info.oo1.ejercicio12VolumenSuperficie;

import java.util.*;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		piezas= new ArrayList<>();
	}
	
	public void agregarPieza(Pieza pieza) {
		piezas.add(pieza);
	}
	
	public double getVolumenDeMaterial(String nombre) {
		return piezas.stream()
			.filter(p -> p.getMaterial()==nombre)
			.mapToDouble(p -> p.getVolumen())
			.sum();
	}
	
	
	public double getSuperficieDeColor(String color) {
		return piezas.stream()
				.filter(p -> p.getColor() == color)
				.mapToDouble(p -> p.getSuperficie())
				.sum();
	}
	
	
}
