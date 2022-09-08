package ar.edu.unlp.info.oo1.ejercicio2Balanza;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
	private List<Producto> productos;
	
	public Balanza() {
		this.ponerEnCero();
	}
	public void ponerEnCero() {
		productos = new ArrayList<>();
	}
	public void agregarProducto(Producto producto) {
		productos.add(producto);
	}
	
	public Ticket emitirTicket() {
		return new Ticket(productos);
	}
	
	public int getCantidadDeProductos() {
		return productos.size();
	}
	public double getPrecioTotal() {
		return productos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}
	public double getPesoTotal() {
		return productos.stream().mapToDouble(producto -> producto.getPeso()).sum();
	}
	
	public List<Producto> getProductos(){
		return productos;
	}
	
	
}
