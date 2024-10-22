package com.example.internaciondomiciliaria.data.remote.models;

import java.io.Serializable;

public class Pacientes implements Serializable {
    private int id;
    private String nombre;
    private int telefono;
    private int dni;
    private ObraSocial obraSocial;
    private String observaciones;
}
