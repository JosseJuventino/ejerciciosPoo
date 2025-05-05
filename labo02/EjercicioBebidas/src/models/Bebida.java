package models;

public abstract class Bebida {
    // ENCAPSULACION
    protected String nombre;
    protected int volumenMililitros;
    protected double precio;
    protected int contadorServicios = 0;

    public Bebida(String nombre, int volumenMililitros, double precio) {
        this.nombre = nombre;
        this.volumenMililitros = volumenMililitros;
        this.precio = precio;
    }

    public abstract int servir();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVolumenMililitros() {
        return volumenMililitros;
    }

    public double getPrecio() {
        return precio;
    }

    public int getContadorServicios() {
        return contadorServicios;
    }
}
