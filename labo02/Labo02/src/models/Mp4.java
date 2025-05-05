package models;

public class Mp4 extends Formato implements Descargable {
    private String resolucion;

    public Mp4(String nombreArchivo, double tamañoMB, String resolucion) {
        super(nombreArchivo, tamañoMB);
        this.resolucion = resolucion;
    }

    @Override
    public int reproducir() {
        contadorReproducciones++;
        System.out.printf("Reproduciendo MP4: %s | Resolución: %s (Reproducción #%d)%n",
                nombreArchivo, resolucion, contadorReproducciones);
        return contadorReproducciones;
    }

    @Override
    public void descargar() {
        System.out.printf("Descargando MP4: %s | Tamaño: %.2f MB%n",
                nombreArchivo, tamañoMB);
    }

    public String getResolucion() {
        return resolucion;
    }
}
