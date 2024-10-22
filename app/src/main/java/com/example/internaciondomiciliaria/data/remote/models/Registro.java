package com.example.internaciondomiciliaria.data.remote.models;

import java.io.Serializable;

public class Registro implements Serializable {
    private int id;
    private String fecha_realizacion;
    private float latutud;
    private float longitud;
    private Visitas visitas;
    private Estado estado;

}
