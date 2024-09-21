package Negocio;

public class Metodo_pago{
	protected int cuotas;
	public double valorMpa;//Este es el valor una vez que se elijio el metodo de pago
	
	public Metodo_pago(int cuotas,double valor) {
		this.cuotas=cuotas;
		this.valorMpa=valor;
		this.validarCuotas(cuotas);
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	public double getValorMpa() {
		return valorMpa;
	}
	
	private void validarCuotas(int cuotas) {
		if(cuotas!=2 && cuotas!=3 && cuotas!=6) {
			System.out.println("La cantidad de cuotas ingresadas no son validas");
		}
	}
}
