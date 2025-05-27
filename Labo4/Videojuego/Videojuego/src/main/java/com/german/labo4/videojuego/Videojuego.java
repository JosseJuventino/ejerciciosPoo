package com.german.labo4.videojuego;

public class Videojuego implements IDescribible {

    private String nombre;
    private String genero;
    private String plataforma;
    private String imageURL;

    public Videojuego() {}

    public Videojuego(String nombre, String genero, String plataforma, String imageURL) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.imageURL = imageURL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String getDescripcion() {
        return nombre + " - " + genero + " en " + plataforma;
    }
}
