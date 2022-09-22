package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import java.time.LocalDate;

public class Factura {
	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	public Factura(double montoEnergiaActiva, double descuento, Usuario usuario) {
		fecha = LocalDate.now();
		this.montoEnergiaActiva = montoEnergiaActiva;
		this.descuento = descuento;
		this.usuario = usuario;
	}
	
	//descuento tomarlo como porcentaje ?
	public double montoTotal() {
		return montoEnergiaActiva * (1-descuento);
	}
	
	public Usuario usuario() {
		return usuario;
	}
	
	public LocalDate fecha() {
		return fecha;
	}
	
	public double descuento() {
		return descuento;
	}
}
