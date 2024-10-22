package com.example.internaciondomiciliaria.data.remote.models;

import java.io.Serializable;

public class Visitas implements Serializable {
    private int id;
    private String fecha;
    private int cantidad;
    private String periodo_inicio;
    private String periodo_fin;
    private String pacientes;
    private boolean estado;
    private Usuarios usuario;
    private int usuarioId;

    public Visitas() {
    }
    public Visitas(int id, String fecha, int cantidad, String periodo_inicio, String periodo_fin, String paciente, boolean estado, Usuarios usuario, int usuarioId) {
        this.id = id;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.periodo_inicio = periodo_inicio;
        this.periodo_fin = periodo_fin;
        this.pacientes = paciente;
        this.estado = estado;
        this.usuario = usuario;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPeriodo_inicio() {
        return periodo_inicio;
    }

    public void setPeriodo_inicio(String periodo_inicio) {
        this.periodo_inicio = periodo_inicio;
    }

    public String getPeriodo_fin() {
        return periodo_fin;
    }

    public void setPeriodo_fin(String periodo_fin) {
        this.periodo_fin = periodo_fin;
    }

    public String getPacientes() {
        return pacientes;
    }

    public void setPacientes(String pacientes) {
        this.pacientes = pacientes;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
