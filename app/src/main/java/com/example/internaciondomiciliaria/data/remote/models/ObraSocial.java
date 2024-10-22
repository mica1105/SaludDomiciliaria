package com.example.internaciondomiciliaria.data.remote.models;

import java.io.Serializable;

public class ObraSocial implements Serializable {
    private int id;
    private String nombre;

    public ObraSocial() {
    }

    public ObraSocial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
