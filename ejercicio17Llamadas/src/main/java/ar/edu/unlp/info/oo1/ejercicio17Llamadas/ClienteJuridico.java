package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

public class ClienteJuridico extends Cliente{
	private String cuit;
	private String tipoPersona;
	
	public ClienteJuridico(String nombre, String direccion, String telefono, String cuit,String tipo) {
		super(nombre, direccion, telefono);
		this.cuit=cuit;
		this.tipoPersona=tipo;
	}
}
