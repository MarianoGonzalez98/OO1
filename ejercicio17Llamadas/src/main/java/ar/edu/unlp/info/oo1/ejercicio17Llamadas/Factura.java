package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.time.LocalDate;

public class Factura {
	private DateLapse periodo;
	private double montoTotal;
	
	
	
	public Factura(DateLapse periodo, double montoTotal) {
		this.periodo = periodo;
		this.montoTotal = montoTotal;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	public LocalDate getFechaInicio() {
		return periodo.getFrom();
	}
	
	public LocalDate getFechaFin() {
		return periodo.getTo();
	}
}
