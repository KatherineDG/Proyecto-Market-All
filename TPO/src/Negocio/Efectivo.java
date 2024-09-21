package Negocio;

public class Efectivo extends Metodo_pago{
	
	public Efectivo(int cuotas,double valor) {
		super(cuotas,valor);
		this.cuotas=0;
		this.valorMpa=A_pagar(valor);
	}
	
	//Al precio se lo rebaja el 10%
	public double A_pagar(double precio) {
		return precio-precio*0.1;
	}

}
