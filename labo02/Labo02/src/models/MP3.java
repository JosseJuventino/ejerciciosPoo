package models;

public class MP3 extends Formato implements Descargable {
    private int bitrateKbps;

    public MP3(String nombreArchivo, double tamañoMB, int bitrateKbps) {
        super(nombreArchivo, tamañoMB);
        this.bitrateKbps = bitrateKbps;
    }

    @Override
    public int reproducir() {
        contadorReproducciones++;
        System.out.printf("Reproduciendo MP3: %s | Bitrate: %dkbps (Reproducción #%d)%n",
                nombreArchivo, bitrateKbps, contadorReproducciones);
        return contadorReproducciones;
    }

    @Override
    public void descargar() {
        System.out.printf("Descargando MP3: %s | Tamaño: %.2f MB%n",
                nombreArchivo, tamañoMB);
    }

    public int getBitrateKbps() {
        return bitrateKbps;
    }
}
