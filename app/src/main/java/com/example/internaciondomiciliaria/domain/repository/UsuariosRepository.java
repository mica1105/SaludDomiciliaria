package com.example.internaciondomiciliaria.domain.repository;



import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.models.Usuarios;

import java.util.List;

public interface UsuariosRepository {
    void getUsuarios(ApiCallback<List<Usuarios>> callback);
}
