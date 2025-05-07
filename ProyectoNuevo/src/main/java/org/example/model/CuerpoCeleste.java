package org.example.model;

public abstract class CuerpoCeleste {
    private final String nombre;
    private final double masa;
    private final double radio;

    protected CuerpoCeleste(String nombre, double masa, double radio) {
        this.nombre = nombre;
        this.masa = masa;
        this.radio = radio;
    }

    public String getNombre() { return nombre; }
    public double getMasa()   { return masa; }
    public double getRadio()  { return radio; }

    @Override
    public String toString() {
        return nombre + " (masa=" + masa + ", radio=" + radio + ")";
    }

}
