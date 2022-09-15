package ar.edu.unlp.info.oo1.ejercicio5Genealogia;

import java.time.LocalDate;

public class Mamifero {
	private String identificador;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String id) {
		this.identificador = id;
	}
	
	public Mamifero() {}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if (madre!=null) {
			return madre.getPadre();			
		}
		return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (madre!=null) {
			return madre.getMadre();			
		}
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (padre!=null) {
			return padre.getPadre();			
		}
		return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if (padre!=null) {
			return padre.getMadre();			
		}
		return null;
	}
	
	
	/*
	if (!tieneAncestro(madre, mamifero)) {
		return (tieneAncestro(padre, mamifero));
	}
	return true;
	*/
	
	public boolean tieneComoAncestroA(Mamifero mamifero) {
		return tieneAncestro(madre, mamifero) || tieneAncestro(padre, mamifero);
	}
	
	private boolean tieneAncestro(Mamifero pepito, Mamifero mamifero) {
		return (pepito!=null) && (pepito.equals(mamifero) || pepito.tieneComoAncestroA(mamifero));
	}
	
	
	private boolean tieneAncestro1(Mamifero pepito, Mamifero mamifero) {
		if (pepito!=null) {
			if (!pepito.equals(mamifero)) {
				return pepito.tieneComoAncestroA(mamifero);
			}else {
				return true;
			}	
		}
		return false;
	}
	
	
}
