package ar.edu.unlp.info.oo1.ejercicio17Llamadas;

public class ClienteFisico extends Cliente{
	private int dni;
	
	public ClienteFisico(String nombre, String direccion, String telefono, int dni) {
		super(nombre, direccion, telefono);
		this.dni=dni;
	}
	
	public Factura facturarLlamadas(String inicio,String fin) {
		Factura f= super.facturarLlamadas(inicio, fin);
		double monto = f.getMontoTotal() * 0.9;
		return new Factura(f.getPeriodo(),monto,this);
	}
}
