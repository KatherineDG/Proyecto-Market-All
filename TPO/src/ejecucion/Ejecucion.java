package ejecucion;
import Negocio.*;

//Pasos paara que el sistema funcione correctamente
//1. Crear Catálogo
//2. Crear Productos
//3. Agregar productos al catálogo
//4. Crear Carrito
//5. Agregar productos al carrito
//5.1 Confirmar Carrito
//6. Crear una Metodo de Pago (creando el objeto de tipo credito, debito o efectivo
//7. Crear Venta
//8. Al crear la venta se especifica Metodo de Pago, Carrito y el Catalogo de productos

public class Ejecucion {

	public static void main(String[] args) {
		Catalogo cat1=new Catalogo();
		Producto p1=new Producto(123,40,"rojo",5,2);
		Producto p2=new Producto(456,102,"azul",8,1);
		cat1.cargar(p2);
		cat1.cargar(p1);
		//System.out.println(p1.getCodigo());
		Carrito c1=new Carrito();
		//c1.cargarProducto(p1);
		//c1.cargarProducto(p2);
		/*double costo=c1.confirmarCarrito();
		Metodo_pago mp1=new Credito(2,costo);
		Venta v1=new Venta(mp1,c1,cat1);
		System.out.println(v1.precioTotal());
		System.out.println(v1.getValorFinal());
		System.out.println(cat1.getListaProductos().get(cat1.buscarProducto(p1)).getStock());
		cat1.mostrarRanking();
		System.out.println(p1.getCant_vendidas());
		System.out.println(p2.getCant_vendidas());*/
		
		//Prueba del ranking
		Producto p3=new Producto(346,40,"amarillo",9,2);
		Producto p4=new Producto(765,102,"naranja",45,4);
		Producto p5=new Producto(295,40,"violeta",19,5);
		Producto p6=new Producto(056,102,"blanco",85,1);
		Producto p7=new Producto(474,40,"negro",52,2);
		Producto p8=new Producto(777,102,"verde",22,8);
		Producto p9=new Producto(224,40,"gris",15,3);
		Producto p10=new Producto(643,102,"rosa",8,4);
		Producto p11=new Producto(761,40,"marron",10,7);
		Producto p12=new Producto(247,102,"celeste",13,2);
		
		cat1.cargar(p3);
		cat1.cargar(p4);
		cat1.cargar(p5);
		cat1.cargar(p6);
		cat1.cargar(p7);
		cat1.cargar(p8);
		cat1.cargar(p9);
		cat1.cargar(p10);
		//cat1.cargar(p11);
		//cat1.cargar(p12);
		/*
		c1.cargarProducto(p3, 7);
		c1.cargarProducto(p4);
		c1.cargarProducto(p5);
		c1.cargarProducto(p6);
		c1.cargarProducto(p7);
		c1.cargarProducto(p8);
		c1.cargarProducto(p9);
		c1.cargarProducto(p10); //producto más vendidos sin los de abajo
		c1.cargarProducto(p10);
		//c1.cargarProducto(p11);
		//c1.cargarProducto(p12);
		*/
		//double costo=c1.confirmarCarrito();
		//Metodo_pago mp1=new Credito(2,costo);
		//Venta v1=new Venta(mp1,c1,cat1);
		
		cat1.mostrarRanking();
		
		
	}
	
}
