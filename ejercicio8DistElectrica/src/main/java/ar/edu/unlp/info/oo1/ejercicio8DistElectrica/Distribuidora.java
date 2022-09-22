package ar.edu.unlp.info.oo1.ejercicio8DistElectrica;

import java.util.*;

public class Distribuidora {
	private double precioKWh;
	//private List<Usuario> usuarios; //da lo mismo en este caso usar cualquiera de los 2?
	private HashSet<Usuario> usuarioss;
	public Distribuidora(double precio) {
		precioKWh = precio;
		usuarioss = new HashSet<Usuario>();
	}
	
	
	public void agregarUsuario(Usuario usuario) {
		usuarioss.add(usuario);
	}
	
	public List<Factura> facturar(){
		List<Factura> facturas = new ArrayList<>();
		usuarioss.forEach(usuario -> 
			facturas.add(usuario.facturarEnBaseA(this.precioKWh()))
		);
		return facturas;
	}
	
	public double consumoTotalActiva() {
		return usuarioss.stream()
				.mapToDouble(usuario -> usuario.ultimoConsumoActiva())
				.sum();
	}
	
	public double precioKWh() {
		return precioKWh;
	}
	
	public List<Usuario> getUsuarios(){
		return new ArrayList<>(usuarioss);
	}
}
