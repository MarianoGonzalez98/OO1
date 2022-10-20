package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;

public class CancelacionFlexible implements ICancelacion{

	public double reembolso(Reserva reserva, LocalDate fechaCancelacion) {
		return reserva.precio();
	}
	
}
