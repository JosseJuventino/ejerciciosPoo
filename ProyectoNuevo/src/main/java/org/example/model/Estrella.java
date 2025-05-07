package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Estrella extends CuerpoCeleste {
    private final List<Planeta> planetas = new ArrayList<>();

    public Estrella(String nombre, double masa, double radio) {
        super(nombre, masa, radio);
    }

    public void agregarPlaneta(Planeta planeta) {
        planetas.add(planeta);
    }

    public List<Planeta> getPlanetas() {
        return List.copyOf(planetas);
    }
}