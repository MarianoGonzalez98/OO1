package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Propiedad propiedad;
	private Usuario inquilino;
	//propietario???
	
	
	public Reserva(DateLapse periodo,Propiedad propiedad, Usuario inquilino) {
		this.periodo=periodo;
		this.propiedad=propiedad;
		this.inquilino=inquilino;
		this.propiedad.agregarReserva(this);
		
	}
	public double precio() {
		return propiedad.getPrecioPorNoche() * periodo.sizeInDays();
	}
	
	public boolean overlaps(DateLapse periodo) {
		return this.periodo.overlaps(periodo);
	}
	
	public boolean eliminar() {
		if (periodo.getFrom().isAfter(LocalDate.now())) {
			propiedad.eliminarReserva(this);
			inquilino.eliminarReserva(this);
			return true;
		}
		return false;
	}
	
	public double calcularReembolso(LocalDate fecha) {
		return propiedad.reembolso(this, fecha);
	}
	
	public DateLapse getPeriodo() {
		return periodo;
	}
}
