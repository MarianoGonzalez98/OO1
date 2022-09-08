package ar.edu.unlp.info.oo1.ejercicio2Balanza;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos; //al pedo?
	private double pesoTotal; //al pedo
	private double precioTotal; //al pedo
	private List<Producto> productos; 
	
	public Ticket(int cantidadDeProductos, double pesoTotal, double precioTotal) { 
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.fecha = LocalDate.now(); 
	}

	public void Ticket2(List<Producto> productos) { //segundo constructor, puede romper tests
		this.productos= productos; 
		this.fecha = LocalDate.now(); 
	}
	public double impuesto() {
		return precioTotal * 0.21;
	}
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos; // igual q en balanza?? no se repite codigo?
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	
	
	
	
	
}
