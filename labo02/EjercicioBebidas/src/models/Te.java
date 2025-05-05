package models;

// Te.java
public class Te extends Bebida implements Calificable {
    private String variedadHojas;       // "verde", "negro"
    private String temperaturaInfusion; // p. ej. "80°C", "100°C"

    public Te(String nombre, int volumenMililitros, double precio,
              String variedadHojas, String temperaturaInfusion) {
        super(nombre, volumenMililitros, precio);
        this.variedadHojas = variedadHojas;
        this.temperaturaInfusion = temperaturaInfusion;
    }

    @Override
    public int servir() {
        contadorServicios++;
        System.out.printf("Sirviendo té: %s | Variedad: %s | Temp. infusión: %s (Servicio #%d)%n",
                nombre, variedadHojas, temperaturaInfusion, contadorServicios);
        return contadorServicios;
    }

    @Override
    public void valorar(int estrellas) {
        System.out.printf("Bebida: %s | Valoración: %d estrellas%n",
                nombre, estrellas);
    }

    public String getVariedadHojas() {
        return variedadHojas;
    }

    public String getTemperaturaInfusion() {
        return temperaturaInfusion;
    }
}
