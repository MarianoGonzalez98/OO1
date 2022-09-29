package ar.edu.unlp.info.oo1.ejercicio11Inversor;

import java.time.LocalDate;
import java.time.Period;

public class PlazoFijo implements Inversion{
	LocalDate fechaDeConstitucion;
	double montoDepositado;
	double porcentajeDeInteresDiario;// 5 

	
	public PlazoFijo(String fecha, double monto, double porcentaje) {
		fechaDeConstitucion= LocalDate.parse(fecha);
		montoDepositado = monto;
		porcentajeDeInteresDiario = porcentaje;
		
	}
	
	public double valorActual() {
		// https://www.gerencie.com/como-calcular-el-interes-compuesto.html
		double interes = 1 + porcentajeDeInteresDiario / 100; //obtengo 1.05 
		Period periodo = Period.between(fechaDeConstitucion, LocalDate.now());
		return montoDepositado * Math.pow(interes, periodo.getDays());
	}
	//10 dias, 1.05, 100 pesos= 162.88
}
