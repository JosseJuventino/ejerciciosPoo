package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class Planeta extends CuerpoCeleste {
    private final List<Luna> lunas = new ArrayList<>();

    public Planeta(String nombre, double masa, double radio) {
        super(nombre, masa, radio);
    }

    public void agregarLuna(Luna luna) {
        lunas.add(luna);
    }

    public List<Luna> getLunas() {
        return List.copyOf(lunas);
    }
}