package org.example.factory;

import org.example.model.CuerpoCeleste;
import org.example.model.Estrella;
import org.example.model.Luna;
import org.example.model.Planeta;

public class CuerpoCelesteFactory {
    public static CuerpoCeleste crear(String tipo, String nombre, double masa, double radio) {
        return switch (tipo.toUpperCase()) {
            case "PLANETA"  -> new Planeta(nombre, masa, radio);
            case "ESTRELLA" -> new Estrella(nombre, masa, radio);
            case "LUNA"     -> new Luna(nombre, masa, radio);
            default -> throw new IllegalArgumentException("Tipo desconocido: " + tipo);
        };
    }
}