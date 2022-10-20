package ar.edu.unlp.info.oo1.ejercicio15Alquiler;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public Sistema() {
		usuarios= new ArrayList<Usuario>();
		propiedades= new ArrayList<Propiedad>();
	}
	
	//Registrar usuarios
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario usuario = new Usuario(nombre, direccion, dni);
		usuarios.add(usuario);
		return usuario;		
	}
	
	//Registrar una propiedad en alquiler:
	public Propiedad registrarPropiedad(Usuario propietario,String nombre, String descripcion, double precio,String direccion, ICancelacion politica) {
		Propiedad propiedad = new Propiedad(nombre, precio, descripcion, politica);
		propietario.agregarPropiedad(propiedad);
		propiedades.add(propiedad);
		return propiedad;
	}
	
	//Buscar propiedades disponibles en un período
	public List<Propiedad> propiedadesDisponibles(DateLapse periodo) {
		return propiedades.stream().filter(p-> p.estaDisponible(periodo)).toList();
	}
	
	//Hacer una reserva
	public Reserva registrarReserva(Propiedad propiedad, DateLapse periodo, Usuario usuario) {
		if (!propiedad.estaDisponible(periodo)) {
			return null;
		}
		return usuario.agregarReserva(propiedad, periodo);
	}
	
	
	//para test??!!
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public List<Propiedad> getPropiedades(){
		return propiedades;
	}
}
