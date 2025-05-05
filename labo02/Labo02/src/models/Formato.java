package models;

public abstract class Formato {
    /**
     * Al declarar los atributos de la clase Formato como protected,
     * permitimos que las subclases (Mp3, Mp4, etc.) accedan directamente
     * a esos campos, pero seguimos impidiendo el acceso directo desde clases
     * ajenas al paquete o que no hereden.
     */
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
