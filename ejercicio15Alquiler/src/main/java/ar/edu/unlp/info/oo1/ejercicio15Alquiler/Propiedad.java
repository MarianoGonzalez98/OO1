package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private double precioPorNoche;
	private String descripcion;
	private List<Reserva> reservas;
	//propietario??
	
	
	public Propiedad(String nombre, double precioPorNoche, String descripcion) {
		this.nombre=nombre;
		this.precioPorNoche=precioPorNoche;
		this.descripcion=descripcion;
		this.reservas=new ArrayList<Reserva>();
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	public boolean estaDisponible(DateLapse periodo) {
		return !reservas.stream().anyMatch(r -> r.overlaps(periodo));
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public double getPrecioPorNoche() {
		return precioPorNoche;
	}
	
	public double getGananciaEntreFechas(DateLapse periodo) {
		return reservas.stream().filter(r -> r.overlaps(periodo)).mapToDouble(r -> r.precio()).sum();
		
	}
}
