package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

public class LlamadaLocal extends Llamada{

	public LlamadaLocal(String fecha, int hora, int duracion, String telOrigen, String telDestino) {
		super(fecha, hora, duracion, telOrigen, telDestino);
		
	}

	
	public double costo() {
		return this.getDuracion() * 1;
	}

}
