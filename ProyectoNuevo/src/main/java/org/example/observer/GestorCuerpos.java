package org.example.observer;

import org.example.model.CuerpoCeleste;

import java.util.ArrayList;
import java.util.List;

public class GestorCuerpos {
    private final List<CuerpoCeleste> cuerpos = new ArrayList<>();
    private final List<Observer> observadores = new ArrayList<>();

    public void registrar(Observer obs) {
        observadores.add(obs);
    }

    public void agregar(CuerpoCeleste cuerpo) {
        cuerpos.add(cuerpo);
        notificar("Agregado: " + cuerpo.getNombre());
    }

    private void notificar(String mensaje) {
        for (Observer obs : observadores) {
            obs.actualizar(mensaje);
        }
    }

    public List<CuerpoCeleste> listar() {
        return List.copyOf(cuerpos);
    }
}
