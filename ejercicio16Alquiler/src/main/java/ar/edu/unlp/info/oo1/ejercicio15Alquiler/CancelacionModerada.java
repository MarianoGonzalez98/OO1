package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.time.LocalDate;

public class CancelacionModerada implements ICancelacion{
	public double reembolso(Reserva reserva, LocalDate fechaCancelacion) {
		DateLapse periodo = reserva.getPeriodo();
		//fecha cancelacion 10
		//periodo.from() minimo 17
		if (fechaCancelacion.isBefore(periodo.getFrom().minusDays(7))) { //si el comienzo es una semana antes o mas de la cancelacion
			return reserva.precio();
		} else if (fechaCancelacion.isBefore(periodo.getFrom().minusDays(2))) {
			return reserva.precio() / 2.0;
		}
		else return 0; //no esta aclarado
	}
}
