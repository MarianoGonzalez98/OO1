package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.time.LocalDate;
import java.time.Period;


public class DateLapse {
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(String from, String to) {
		this.from=LocalDate.parse(from);
		this.to=LocalDate.parse(to);
		
	}

	public LocalDate getFrom() {
		return from;
	}
	//“Retorna la fecha de fin del rango”
	public LocalDate getTo() {
		return to;
	}
	
	//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'” ¿inclusiva o exclusiva?
	public int sizeInDays() {
		return Period.between(from, to).getDays();
	}
	
	/* “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to
	del receptor y false en caso contrario”.
	 */
	public boolean includesDate(LocalDate other) {
		return ! (other.isBefore(from) || other.isAfter(to));
	}
	
	/**
	Retorna true si el período de tiempo del receptor se superpone con el
	recibido por parámetro
	**/
	public boolean overlaps (DateLapse anotherDateLapse ) {
		if (this.includesDate(anotherDateLapse.getFrom()) || this.includesDate(anotherDateLapse.getTo())) {
			return true;
		}
		return false;
	}
}