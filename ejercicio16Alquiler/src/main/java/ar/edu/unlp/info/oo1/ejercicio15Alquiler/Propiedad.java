package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private double precioPorNoche;
	private String descripcion;
	private ICancelacion politica;
	private List<Reserva> reservas;
	//propietario??
	
	
	public Propiedad(String nombre, double precioPorNoche, String descripcion, ICancelacion politica) {
		this.nombre=nombre;
		this.precioPorNoche=precioPorNoche;
		this.descripcion=descripcion;
		this.reservas=new ArrayList<Reserva>();
		this.politica=politica;
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
	
	public double reembolso(Reserva reserva,LocalDate fecha) {
		return politica.reembolso(reserva, fecha);
	}
}
