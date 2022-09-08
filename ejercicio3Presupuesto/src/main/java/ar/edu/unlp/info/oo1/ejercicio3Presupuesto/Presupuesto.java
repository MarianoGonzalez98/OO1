package ar.edu.unlp.info.oo1.ejercicio3Presupuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> listaItems;
	
	public Presupuesto() {
		listaItems= new ArrayList<>();
		fecha= LocalDate.now();
	}
	
	public Presupuesto cliente(String nombre) {
		this.cliente = nombre;
		return this;
	}
	
	public void agregarItem(Item item) {
		listaItems.add(item);
	}
	
	public double calcularTotal2() {
		double suma = 0;
		for (Item item : listaItems) {
			suma+=item.costo();
		}
		return suma;
	}
	public double calcularTotal() {
		return listaItems.stream().mapToDouble(item -> item.costo()).sum();
	}
}
