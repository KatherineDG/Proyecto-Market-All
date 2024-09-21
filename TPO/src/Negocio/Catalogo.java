package Negocio;
import java.util.ArrayList;
import java.util.List;

public class Catalogo{
	public List <Producto> listaProductos = new ArrayList <Producto>();
	

	public void cargar(Producto producto) {
		this.listaProductos.add(producto);
	}
	
	public void eliminarProducto(Producto prod) {
		this.listaProductos.remove(prod);
	}
	
	//lo usamos para la interface, Busca a un producto por su codigo, devuelve el indice
	public Producto BuscarProductoxCodigo(int codigo) {
		int indice = 0;
		for(Producto p : this.listaProductos) {
			if (p.getCodigo() == codigo) {
				indice = this.listaProductos.indexOf(p);
			}
		}
		return this.listaProductos.get(indice);
	}
	
	//Devuelve el indice en el que se encuentra 
	public int buscarProducto(Producto producto) {
		return listaProductos.indexOf(producto);
	}
	public void modificarCodigo(int codigo,Producto producto) {
		int indice=buscarProducto(producto);
		listaProductos.get(indice).setCodigo(codigo);
	}
	public void modificarPrecio(double precio,Producto producto) {
		int indice=buscarProducto(producto);
		listaProductos.get(indice).setPrecio(precio);
	}
	public void modificarStock(int stock,Producto producto) {
		int indice=buscarProducto(producto);
		listaProductos.get(indice).setStock(stock);
	}
	public void modificarDescripcion(String descripcion,Producto producto) {
		int indice=buscarProducto(producto);
		listaProductos.get(indice).setDescripcion(descripcion);
	}
	public void modificarStockMinimo(int stockMinimo,Producto producto) {
		int indice=buscarProducto(producto);
		listaProductos.get(indice).setStock_minimo(stockMinimo);
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	
	//Ordenamos la lista en forma descendente con el metodo de burbujeo, segun la cantidad de ventas de los productos
	public void ordenarLista(List<Producto> lista) {
	    for (int i = 0; i < lista.size(); i++) {
	        for (int j = 0; j < lista.size(); j++) {
	            if(lista.get(i).getCant_vendidas() > lista.get(j).getCant_vendidas()) {
	                Producto aux = lista.get(i);
	                lista.set(i, lista.get(j));
	                lista.set(j, aux);
	            }
	        }
	    }
	}
	
	//Muestra el ranking, para una ejecucion en la consola
	public void mostrarRanking() {
		this.ordenarLista(listaProductos);
		int largoLista=listaProductos.size();
		//Para que imprima solo 10 productos, si es que la lista tiene más de 10 o menos de 10 que imprima los que están.
		int i = 0;
		if (largoLista >= 10) {
			while (i < 10) {
				System.out.println(this.listaProductos.get(i).getDescripcion());
				i++;
			}
		}
		else {
			while (i < largoLista) {
				System.out.println(this.listaProductos.get(i).getDescripcion());
				i++;
			}
		}
			
	}
	
	//El ranking se guarda en una lista
	public String [] ListaRanking() {
		this.ordenarLista(listaProductos);
		int largoLista=listaProductos.size();
		//Para que tome solo 10 productos, si es que la lista tiene más de 10 o menos de 10 que imprima los que están.
		String [] lista = new String[10];
		int i = 0;
		if (largoLista >= 10) {
			while (i < 10) {
				lista[i] = this.listaProductos.get(i).getDescripcion();
				i++;
			}
		}
		else {
			while (i < largoLista) {
				lista[i] = this.listaProductos.get(i).getDescripcion();
				i++;
			}
		}
		return lista;
			
	}

}
