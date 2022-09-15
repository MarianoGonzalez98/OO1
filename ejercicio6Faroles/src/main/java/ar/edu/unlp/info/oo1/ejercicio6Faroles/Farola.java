package ar.edu.unlp.info.oo1.ejercicio6Faroles;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean estado;
	private List<Farola> vecinas;
	
	public Farola () {
		estado = false;
		vecinas = new ArrayList<Farola>();
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos
	entre las farolas es recíproca, es decir el receptor del mensaje será vecino
	de otraFarola, al igual que otraFarola también se convertirá en vecina del
	receptor del mensaje
	*/	
	public void pairWithNeighbor( Farola otraFarola ) {
		if (!vecinas.contains(otraFarola)) { //es evitable el if con una lista???? si, con || ._.
			vecinas.add(otraFarola);
			//if (!otraFarola.getNeighbors().contains(this)) { //si no me tiene en sus vecinos, me agrego. Para evitar llamada recursiva?
				otraFarola.pairWithNeighbor(this);				
			//}
		}
	}
	
	//Retorna sus farolas vecinas
	public List<Farola> getNeighbors(){
		return vecinas;
	}
	
	//Si la farola no está encendida, la enciende y propaga la acción.
	public void turnOn() {
		if (!estado) {
			estado=true;
			vecinas.forEach(farola -> farola.turnOn());
		}
	}
	
	public void turnOff() {
		if (estado) {
			estado=false;
			for (Farola farola : vecinas) {
				farola.turnOff();					
			}
		}
	}
	
	public boolean isOn() {
		return estado;
	}
}
