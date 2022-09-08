package ar.edu.unlp.info.oo1.ejercicio3Presupuesto;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item detalle(String detalle) {
		this.detalle=detalle;
		return this;
	}
	
	public Item costoUnitario(double costo) {
		this.costoUnitario=costo;
		return this;
	}
	
	public Item cantidad(int cant) {
		this.cantidad=cant;
		return this;
	}
	
	public double costo() {
		return this.cantidad * this.costoUnitario;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}
	
}
