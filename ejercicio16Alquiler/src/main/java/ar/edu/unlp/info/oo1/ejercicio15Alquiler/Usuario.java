package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Reserva> reservas;
	private List<Propiedad> propiedades;
	
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre= nombre;
		this.direccion= direccion;
		this.dni=dni;
		reservas = new ArrayList<Reserva>();
		propiedades = new ArrayList<Propiedad>();
	}
	
	public void agregarPropiedad(Propiedad propiedad) {
		propiedades.add(propiedad);
	}
	public Reserva agregarReserva(Propiedad propiedad, DateLapse periodo) {
		Reserva reserva = new Reserva(periodo, propiedad, this);
		reservas.add(reserva);
		return reserva;
	}
	public void eliminarReserva(Reserva reserva){
		reservas.remove(reserva);
	}
	
	//Obtener las reservas de un usuario
	public List<Reserva> obtenerReservas() {
		return reservas;
	}
	
	//Calcular los ingresos de un propietario
	public double ingresosEntreFechas(String fechaInicio, String fechaFin) {
		DateLapse periodo = new DateLapse(fechaInicio, fechaFin);
		return propiedades.stream().mapToDouble(p -> p.getGananciaEntreFechas(periodo)).sum();
	}
	
	
	//para tests
	public String getDireccion() {
		return direccion;
	}
	 public int getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Propiedad> getPropiedades() {
		return propiedades;
	}
}
