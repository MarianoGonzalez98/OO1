package ar.edu.unlp.info.oo1.ejercicio12VolumenSuperficie;

public abstract class Pieza {
	private String material;
	private String color;
	
	protected Pieza(String material, String color) {
		this.material=material; // si this accede desde la clase hija, como accede a material que es privada de pieza?
		this.color= color;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public String getColor(){
		return color;
	}
	
	public abstract double getVolumen();
	public abstract double getSuperficie();
}
