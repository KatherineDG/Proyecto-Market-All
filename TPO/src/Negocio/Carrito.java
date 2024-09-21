package Negocio;
import java.util.*;
public class Carrito {

    private List <Producto> listaCompra = new ArrayList <Producto> (); // una lista de productos a comprar
    private double precioTotal;
    private boolean carritoConfirmado;
    
    
    //Agrega un producto al carrito, especificando produco y cantidad
    public void cargarProducto(Producto producto, int cantAcomprar) {
        if(carritoConfirmado) {
            System.out.println("No se pueden agregar mas productos por que el carrito ha sido confirmado");
        }
        else if(producto.getStock()==0){
            System.out.println("No hay mas stock de este producto");
        }
        else {
            listaCompra.add(producto);
            producto.setCantidadAComprar(cantAcomprar);
        }
    }
    
    public void EliminarProducto(Producto producto) {
        if(carritoConfirmado) {
            System.out.println("No se pueden eliminar productos por que el carrito ha sido confirmado");
        }else {
            this.listaCompra.remove(producto);
            System.out.print("ENTRO");
            producto.setCantidadAComprar(0);
        }
    }
    
    public double precioTotal(List <Producto> listaCompra) {
        double precioTotal=0;
        for(Producto i:listaCompra) {
            precioTotal+=i.getPrecio()*i.getCantidadAComprar();
        }
        return this.precioTotal=precioTotal;
    }
    
    public List<Producto> getListaCompra() {
        return listaCompra;
    }
    
    public boolean confirmarCarrito() {
        this.precioTotal(listaCompra);
        this.carritoConfirmado=true;
        return true;
    }
	
	
	//Metodo para la interfaz, encontrar el producto por su codigo en el carrito, retonra true o false, si esta o no
	public boolean EncontrarProductoxCodigo(int codigo) {
		boolean encontrado = false;
		for(Producto p : this.listaCompra) {
			if (p.getCodigo() == codigo) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	public Producto BuscarProductoxCodigoCarr(int codigo) {
		int indice = 0;
		for(Producto p : this.listaCompra) {
			if (p.getCodigo() == codigo) {
				indice = this.listaCompra.indexOf(p);
			}
		}
		return this.listaCompra.get(indice);
	}
}
