package models;

public abstract class Formato {
    protected String nombreArchivo;
    protected double tamañoMB;
    protected int contadorReproducciones = 0;

    public Formato(String nombreArchivo, double tamañoMB) {
        this.nombreArchivo = nombreArchivo;
        this.tamañoMB = tamañoMB;
    }
    public abstract int reproducir();

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public double getTamañoMB() {
        return tamañoMB;
    }

    public int getContadorReproducciones() {
        return contadorReproducciones;
    }
}
