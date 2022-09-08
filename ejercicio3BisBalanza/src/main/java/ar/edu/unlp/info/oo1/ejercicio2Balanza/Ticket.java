package ar.edu.unlp.info.oo1.ejercicio2Balanza;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private List<Producto> productos; 
	

	public Ticket(List<Producto> productos) { //segundo constructor, puede romper tests
		this.productos= productos; 
		this.fecha = LocalDate.now(); 
	}
	public double impuesto() {
		return getPrecioTotal() * 0.21;
	}
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidadDeProductos() {
		return productos.size(); // igual q en balanza?? no se repite codigo?
	}

	public double getPesoTotal() {
		return productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}

	public double getPrecioTotal() {
		return productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}
	
	
	
	
	
}
