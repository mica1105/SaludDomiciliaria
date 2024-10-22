package com.example.internaciondomiciliaria.data.remote.models;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private int id;
    private String email;
    private String password;

    public Usuarios() {

    }
    public Usuarios(String email, int id, String password) {
        this.email = email;
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
