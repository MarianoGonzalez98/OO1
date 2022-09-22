package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String domicilio;
	private String nombre;
	private List<Factura> facturas;
	private List<Consumo> consumos;
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		facturas = new ArrayList<Factura>();
		consumos = new ArrayList<Consumo>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		consumos.add(medicion);
	}
	
	public Consumo ultimoConsumo() {
		return consumos.stream()
				.max((c1,c2) -> c1.getFecha().compareTo(c2.getFecha()))
				.orElse(null);
	}
	
	public double ultimoConsumoActiva(){ // usar stream??
		Consumo ultimoConsumo = ultimoConsumo();
		
		if (ultimoConsumo != null) {
			return ultimoConsumo.getConsumoEnergiaActiva();
		}
		return 0;
	}
	
	public double calcularDescuento(double fpe) {
		if (fpe > 0.8) {
			return 0.10;
		}
		return 0;
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimoConsumo = this.ultimoConsumo();
		if (ultimoConsumo==null) {
			return new Factura(0,0,this);
		}
		double descuento = this.calcularDescuento(ultimoConsumo.factorDePotencia());
		
		Factura factura= new Factura(ultimoConsumo.costoEnBaseA(precioKWh), descuento, this);
		facturas.add(factura);
		return factura;
	}
	
	public List<Factura> facturas() {
		return facturas;
	}

	//metodos inutiles?
	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}
	

}
