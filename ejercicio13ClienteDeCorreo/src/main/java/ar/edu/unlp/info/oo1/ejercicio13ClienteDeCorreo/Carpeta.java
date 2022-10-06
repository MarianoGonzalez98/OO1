package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public void eliminarEmail(Email email) {
		this.emails.remove(email);
	}
	
	public double tamanio() {
		double tamanioEmails = emails.stream()
				.mapToDouble(e -> e.tamanio()).sum();
		return tamanioEmails;
	}
	
	public Email mailConTexto(String texto) {
		return emails.stream()
				.filter( e -> e.contieneTexto(texto))
				.findFirst()
				.orElse(null);
				
	}
}
