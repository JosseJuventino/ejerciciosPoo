package org.example;

import org.example.factory.CuerpoCelesteFactory;
import org.example.model.CuerpoCeleste;
import org.example.observer.GestorCuerpos;
import org.example.observer.Observer;

public class Main {
    public static void main(String[] args) {
        GestorCuerpos gestor = new GestorCuerpos();
        Observer consola = mensaje -> System.out.println("[Notificación] " + mensaje);
        gestor.registrar(consola);

        CuerpoCeleste tierra   = CuerpoCelesteFactory.crear("PLANETA",  "Tierra",   5.97e24, 6371);
        CuerpoCeleste sol = CuerpoCelesteFactory.crear("ESTRELLA", "Sol",      1.99e30, 696340);
        CuerpoCeleste luna = CuerpoCelesteFactory.crear("LUNA",     "Luna",     7.35e22, 1737);

        gestor.agregar(tierra);
        gestor.agregar(sol);
        gestor.agregar(luna);

        System.out.println("\n=== Listado de Cuerpos Celestes ===");
        for (CuerpoCeleste c : gestor.listar()) {
            System.out.println(" • " + c);
        }
    }
}