package Negocio;

public class Debito extends Metodo_pago{
	
	public Debito(int cuotas,double valor) {
		super(cuotas,valor);
		this.cuotas=0;
	}
	
	//El precio es el mismo
	public double A_pagar(int precio) {
		return precio;
	}
}
