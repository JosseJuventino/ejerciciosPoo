package models;

public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int stock;
    protected int ventasRegistradas = 0;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public abstract int vender();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getVentasRegistradas() {
        return ventasRegistradas;
    }
}
