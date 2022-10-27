package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

public class LlamadaInternacional extends Llamada{
	
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional(String fecha, int hora, int duracion, String telOrigen, String telDestino,String paisOrigen,String paisDestino) {
		super(fecha, hora, duracion, telOrigen, telDestino);
		this.paisDestino=paisDestino;
		this.paisOrigen=paisOrigen;
	}

	public double costo() {
		if (this.getHora()>8 && this.getHora()<20) {
			return 4 * this.getDuracion();
		}
		return 3 * getDuracion();
	}
}
