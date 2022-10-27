package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

public class LlamadaInterurbana extends Llamada{
	
	private int distancia;
	
	public LlamadaInterurbana(String fecha, int hora, int duracion, String telOrigen, String telDestino,int distancia) {
		super(fecha, hora, duracion, telOrigen, telDestino);
		this.distancia=distancia;
	}
	
	public double costo() {
		double costoMinuto;
		if (distancia<100) {
			costoMinuto=2;
		}else if (distancia <500) {
			costoMinuto=2.5;
		}else {
			costoMinuto=3;
		}
		return  5.0 + costoMinuto * this.getDuracion();
	}
	
}
