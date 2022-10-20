package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;

public class CancelacionEstricta implements ICancelacion{

	@Override
	public double reembolso(Reserva reserva, LocalDate fechaCancelacion) {
		return 0;
	}

}
