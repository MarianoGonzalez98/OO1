package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nombre;
	private String direccion;
	private String telefono;
	private List<Llamada> llamadas;
	
	public Cliente(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.llamadas = new ArrayList<>();
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void registrarLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
	
	public Factura facturarLlamadas(String inicio, String fin) {
		DateLapse periodo= new DateLapse(inicio, fin);
		double monto = llamadas.stream().filter(l -> l.estaEnPeriodo(periodo)).mapToDouble(l -> l.costo()).sum();
		return new Factura(periodo,monto,this);
	}
	
	public boolean tieneTelefono(String telefono) {
		return this.telefono.equals(telefono);
	}
}
