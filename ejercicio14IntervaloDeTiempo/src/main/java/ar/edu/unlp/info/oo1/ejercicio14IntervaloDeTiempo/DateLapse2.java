package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.Period;

public class DateLapse2 implements IDateLapse{
	private LocalDate from;
	private int sizeInDays;
	
	
	public DateLapse2(String from, int sizeInDays) { //deberia mantener constructor
		this.from=LocalDate.parse(from);
		this.sizeInDays=sizeInDays;
		
	}

	public LocalDate getFrom() {
		return from;
	}
	//“Retorna la fecha de fin del rango”
	public LocalDate getTo() {
		return from.plusDays(sizeInDays);
	}
	
	//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'” ¿inclusiva o exclusiva?
	public int sizeInDays() {
		return Period.between(from, this.getTo()).getDays();
	}
	
	/* “recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to
	del receptor y false en caso contrario”.
	 */
	public boolean includesDate(LocalDate other) {
		return ! (other.isBefore(from) || other.isAfter(this.getTo()));
	}
}
