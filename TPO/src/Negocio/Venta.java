package Negocio;
import java.util.*;
public class Venta {
	/* valor va a ser el precio total, obtenido de carrito y su metodo*/
	protected Metodo_pago metodoPago;
	private double valorFinal;
	public List<Producto>carritoConfirmado;
	
	public Venta(Metodo_pago metodoPago,Carrito carrito,Catalogo catalogo) {
		this.metodoPago = metodoPago;
		this.valorFinal = metodoPago.getValorMpa();
		this.carritoConfirmado=carrito.getListaCompra();
		this.SumarCantVendidas(catalogo);
	}
	
	public Metodo_pago getMetodoPago() {
		return metodoPago;
	}
	
	public double getValorFinal() {
		return valorFinal;
	}
	
	public List<Producto> getCarritoConfirmado() {
		return carritoConfirmado;
	}
	
    //calcula el precio total del carrito confirmado sin descuentos para enviarlo a metodo_pago
	public double precioTotal() {
        double precioTotal=0;
        for(Producto i:this.carritoConfirmado) {
            precioTotal+=i.getPrecio()*i.getCantidadAComprar();
        }
        return precioTotal;
    }

    //cambia unicamente el stock de los productos comprados,lo hace automaticamente en el constructor y avisa si se alcanzo el stock minimo
	public List <Integer> cambiarStock(Catalogo catalogo) {
		boolean reponer = false;
		List <Integer> listaReponer = new ArrayList <Integer> ();
        for(Producto p:carritoConfirmado) {
            int indice=catalogo.getListaProductos().indexOf(p);
            catalogo.getListaProductos().get(indice).setStock(p.getStock()-p.getCantidadAComprar());
            if (catalogo.getListaProductos().get(indice).getStock()<=catalogo.getListaProductos().get(indice).getStock_minimo()) {
                System.out.println("El producto de codigo"+catalogo.getListaProductos().get(indice).getCodigo()+"requiere reponer stock");
                listaReponer.add(catalogo.getListaProductos().get(indice).getCodigo());
                reponer = true;
            }
        }
        if (reponer == true) {
        	return listaReponer;
        }
        else {
        	return null;
        }
    }
	
	//define la cant de unidades vendidas de los productos sumando de a 1 al atributo cantVendidas de Producto
	public void SumarCantVendidas(Catalogo catalogo) {
        for(Producto p:carritoConfirmado) {
            int indice=catalogo.getListaProductos().indexOf(p);
            catalogo.getListaProductos().get(indice).setCant_vendidas(p.getCant_vendidas()+p.getCantidadAComprar());
        }
    }
}
