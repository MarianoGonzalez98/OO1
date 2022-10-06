package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private List<Carpeta> carpetas;
	private Carpeta inbox;
	
	
	public ClienteDeCorreo(String nombreInbox) {
		this.inbox = new Carpeta(nombreInbox);
		this.carpetas = new ArrayList<>();
		carpetas.add(inbox);
	}
	
	public void recibir (Email email) {
		inbox.agregarEmail(email);
	}
	
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		destino.agregarEmail(email);
		origen.eliminarEmail(email);
	}
	
	public Email buscar(String texto) {
		
		return carpetas.stream()
				.map( c -> c.mailConTexto(texto) )
				.filter( c -> c != null )
				.findFirst()
				.orElse(null);
	}
	
	public double espacioOcupado() { //cambie int por double
		return carpetas.stream()
				.mapToDouble(c -> c.tamanio())
				.sum();
	}
	
	public Carpeta inbox() {
		return this.inbox;
	}
	
	public List<Carpeta> carpetas(){
		return this.carpetas;
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		carpetas.add(carpeta);
	}
	
	
}
