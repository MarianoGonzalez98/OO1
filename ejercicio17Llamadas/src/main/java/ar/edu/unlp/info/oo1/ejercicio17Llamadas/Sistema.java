package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<String> telefonos;
	private List<Cliente> clientes;
	
	public Sistema() {
		telefonos= new ArrayList<>();
		clientes=new ArrayList<>();
	}
	
	public void agregarTelefono(String tel) {
		telefonos.add(tel);
	}
	
	public String obtenerTelefono() {
		if (telefonos.isEmpty()) {
			return null;
		}
		String telefono= telefonos.remove(0); //retiro el telefono de los disponibles y lo guardo
		return telefono;
	}
	
	public Cliente agregarClienteFisico(String nombre, String direccion, int dni) {
		String telefono= this.obtenerTelefono();
		if (telefono==null) {
			return null;
		}
		Cliente cliente = new ClienteFisico(nombre,direccion,telefono,dni);
		clientes.add(cliente);
		return cliente;
	}
	
	public Cliente agregarClienteJuridico(String nombre, String direccion, String cuit,String tipo){
		String telefono= this.obtenerTelefono();
		if (telefono==null) {
			return null;
		}
		Cliente cliente = new ClienteJuridico(nombre,direccion,telefono,cuit,tipo);
		clientes.add(cliente);
		return cliente;
	}
	
	public Cliente obtenerCliente(String telefono) {
		Cliente cliente = clientes.stream().filter(c -> c.tieneTelefono(telefono)).findAny().orElse(null);
		return cliente;
	}
	
	public Llamada registrarLlamadaLocal(String fecha, int hora, int duracion, String telOrigen, String telDestino) {
		Cliente cliente = this.obtenerCliente(telOrigen);
		if (cliente==null) { //por si no existe el cliente con ese telefono
			return null;
		}
		//se deberia instanciar la llamada dentro de la clase que la va a conocer
		Llamada l = new LlamadaLocal(fecha,hora,duracion,telOrigen,telDestino);
		cliente.registrarLlamada(l);
		return l;
		
	}
	
	
	public Llamada registrarLlamadaInterUrbana(String fecha, int hora, int duracion, String telOrigen, String telDestino,int distancia) {
		Cliente cliente = this.obtenerCliente(telOrigen);
		if (cliente==null) { //por si no existe el cliente con ese telefono
			return null;
		}
		Llamada l = new LlamadaInterurbana(fecha,hora,duracion,telOrigen,telDestino,distancia);
		cliente.registrarLlamada(l);
		return l;
	}
	
	public Llamada registrarLlamadaInternacional(String fecha, int hora, int duracion, String telOrigen, String telDestino,String paisOrigen,String paisDestino) {
		Cliente cliente = this.obtenerCliente(telOrigen);
		if (cliente==null) { //por si no existe el cliente con ese telefono
			return null;
		}
		Llamada l = new LlamadaInternacional(fecha,hora,duracion,telOrigen,telDestino,paisOrigen,paisDestino);
		cliente.registrarLlamada(l);
		return l;
		
	}
	
	
}
