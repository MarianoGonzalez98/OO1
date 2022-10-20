package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;

public interface ICancelacion {
	public double reembolso(Reserva reserva, LocalDate fechaCancelacion);
}
