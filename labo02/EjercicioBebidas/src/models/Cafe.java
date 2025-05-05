package models;

// Cafe.java
public class Cafe extends Bebida implements Calificable {
    private int intensidad;        // 1–5
    private String tipoTueste;     // "claro" o "oscuro"

    public Cafe(String nombre, int volumenMililitros, double precio,
                int intensidad, String tipoTueste) {
        super(nombre, volumenMililitros, precio);
        this.intensidad = intensidad;
        this.tipoTueste = tipoTueste;
    }

    @Override
    public int servir() {
        contadorServicios++;
        System.out.printf("Sirviendo café: %s | Intensidad: %d | Tueste: %s (Servicio #%d)%n",
                nombre, intensidad, tipoTueste, contadorServicios);
        return contadorServicios;
    }

    // polimorfismo
    @Override
    public void valorar(int estrellas) {
        System.out.printf("Bebida: %s | Valoración: %d estrellas%n",
                nombre, estrellas);
    }

    public int getIntensidad() {
        return intensidad;
    }

    public String getTipoTueste() {
        return tipoTueste;
    }
}

