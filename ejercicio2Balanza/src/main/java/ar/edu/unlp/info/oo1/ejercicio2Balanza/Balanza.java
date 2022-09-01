package ar.edu.unlp.info.oo1.ejercicio2Balanza;

public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public Balanza() {
		this.ponerEnCero();
	}
	public void ponerEnCero() {
		pesoTotal=0;
		precioTotal=0;
		cantidadDeProductos=0;
	}
	public void agregarProducto(Producto producto) {
		pesoTotal+=producto.getPeso();
		precioTotal+=producto.getPrecio();
		cantidadDeProductos++;
	}
	
	public Ticket emitirTicket() {
		return new Ticket(cantidadDeProductos,pesoTotal,precioTotal);
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	
	
}
