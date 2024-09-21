package Negocio;

public class Producto {
    private int codigo;
    private double precio;
    private String descripcion;
    private int stock;
    private int stock_minimo;
    private int cantVendidas=0;
    private int cantidadAComprar;
    
    
    public Producto(int codigo,double precio,String descripcion,int stock,int stock_minimo) {
        this.codigo=codigo;
        this.precio=precio;
        this.descripcion=descripcion;
        this.stock=stock;
        this.stock_minimo=stock_minimo;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getStock_minimo() {
        return stock_minimo;
    }
    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }
    public void setCant_vendidas(int cantVendidas) {
        this.cantVendidas=cantVendidas;
    }
    public int getCant_vendidas() {
        return this.cantVendidas;
    }
    public int getCantidadAComprar() {
        return cantidadAComprar;
    }
    public void setCantidadAComprar(int cantidadAComprar) {
        this.cantidadAComprar = cantidadAComprar;
    }
}