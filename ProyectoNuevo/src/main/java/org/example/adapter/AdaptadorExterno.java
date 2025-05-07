package org.example.adapter;

import org.example.model.CuerpoCeleste;

class DatosExterno {
    public String obtenerNombre() { /* ... */ return ""; }
    public double obtenerMasa()    { /* ... */ return 0; }
    public double obtenerRadio()   { /* ... */ return 0; }
}

public class AdaptadorExterno extends CuerpoCeleste {
    private final DatosExterno externo;

    public AdaptadorExterno(DatosExterno externo) {
        super(externo.obtenerNombre(), externo.obtenerMasa(), externo.obtenerRadio());
        this.externo = externo;
    }
}