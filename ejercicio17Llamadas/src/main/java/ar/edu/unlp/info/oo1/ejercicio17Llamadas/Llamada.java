package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.time.LocalDate;

public abstract class Llamada {
	private LocalDate fecha;
	private int hora;
	private int duracion;
	private String telOrigen;
	private String telDestino;
	
	public Llamada(String fecha,int hora,int duracion, String telOrigen,String telDestino) {
		this.fecha=LocalDate.parse(fecha);
		this.hora=hora;
		this.duracion=duracion;
		this.telOrigen=telOrigen;
		this.telDestino=telDestino;
	}
	
	public boolean estaEnPeriodo(DateLapse periodo) {
		return periodo.includesDate(fecha);
	}
	
	public abstract double costo();
	
	
}
