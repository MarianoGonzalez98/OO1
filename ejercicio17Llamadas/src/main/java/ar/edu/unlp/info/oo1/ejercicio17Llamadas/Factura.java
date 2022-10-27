package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.time.LocalDate;

public class Factura {
	private DateLapse periodo;
	private double montoTotal;
	private Cliente cliente;
	
	
	public Factura(DateLapse periodo, double montoTotal, Cliente cliente) {
		this.periodo = periodo;
		this.montoTotal = montoTotal;
		this.cliente=cliente;
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
	
	public DateLapse getPeriodo() {
		return periodo;
	}
}
