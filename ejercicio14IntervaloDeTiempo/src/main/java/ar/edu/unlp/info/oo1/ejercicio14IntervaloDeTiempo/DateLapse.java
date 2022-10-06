package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempo;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/*

Investigue cómo hacer para crear una fecha determinada, por ejemplo 15/09/1972.

LocalDate.parse("1972-09-15")
LocalDate.of(year, month, day)

LocalDate.plusDays(long daysToAdd)

Investigue cómo hacer para determinar si la fecha de hoy se encuentra entre las
fechas 15/12/1972 y 15/12/2018. Sugerencia: vea los métodos permiten comparar
LocalDates y que retornan booleans.


sAfter(), isBefore() and isEqual() Methods

return !(testDate.before(startDate) || testDate.after(endDate)); inclusivo?

return testDate.after(startDate) && testDate.before(endDate);


Investigue cómo hacer para calcular el número de días entre dos fechas. Lo mismo
para el número de meses y de años Sugerencia: vea el método until.
Tenga en cuenta que los métodos de LocalDate colaboran con otros objetos que
están definidos a partir de enums, clases e interfaces de java.time; por ejemplo
java.time.temporal.ChronoUnit.DAYS

Period.between(fechaComienzo, fechaFin);

DAYS.between(dateBefore, dateAfter)

 */


public class DateLapse implements IDateLapse{
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
}
