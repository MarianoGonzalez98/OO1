package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{

	@Override
	protected boolean puedeExtraer(double monto) {
		return monto* 1.02 <= this.getSaldo();
	}
	
	protected void extraerSinControlar(double monto) {
		super.extraerSinControlar(monto * 1.02);
	}
	
	public void depositar(double monto) {
		super.depositar(monto * 0.98);
	}

}
