package Negocio;

public class Credito extends Metodo_pago{
	
	public Credito(int cuotas,double valor) {
		super(cuotas,valor);
		this.valorMpa=A_pagar(valor);
	}
	
	//Al precio, dependiendo la cuota se le aumenta un cierto porcentaje
	public double A_pagar(double precio) {
		if (this.cuotas==2) {
			precio+=precio*0.06;
		}
		else if(this.cuotas==3){
			precio+=precio*0.12;
		}
		else if(this.cuotas==6) {
			precio+=precio*0.2;
		}
		return precio;
	}
}
