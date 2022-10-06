package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Email {
	private List<Archivo> adjuntos;
	private String titulo;
	private String cuerpo;
	
	public Email(String titulo, String cuerpo) {
		this.adjuntos = new ArrayList<>();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	public List<Archivo> adjuntos() {
		return adjuntos;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}
	
	//agregado
	public void agregarAdjunto(Archivo archivo) {
		adjuntos.add(archivo);
	}
	
	public double tamanio() {
		double tamanioAdjuntos = adjuntos.stream().mapToDouble(a -> a.tamanio()).sum(); 
		return tamanioAdjuntos + titulo.length() + cuerpo.length();
	}
	
	public boolean contieneTexto(String texto) {
		return this.titulo.contains(texto) || this.cuerpo.contains(texto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjuntos, cuerpo, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(adjuntos, other.adjuntos) && Objects.equals(cuerpo, other.cuerpo)
				&& Objects.equals(titulo, other.titulo);
	}
	
	
	
}
