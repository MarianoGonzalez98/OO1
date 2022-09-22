package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo(LocalDate fecha, double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = fecha;
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	
	public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.fecha = LocalDate.now();
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	public double costoEnBaseA(double precioKWh) {
		return consumoEnergiaActiva * precioKWh;
	}
	
	public double factorDePotencia() {
		return consumoEnergiaActiva /
				Math.sqrt(Math.pow(consumoEnergiaActiva, 2) + Math.pow(consumoEnergiaReactiva, 2) );
	}
	
	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
}
