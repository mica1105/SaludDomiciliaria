package com.example.internaciondomiciliaria.data.repository;

import android.util.Log;

import com.example.internaciondomiciliaria.data.local.AppDatabase;
import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.ApiService;
import com.example.internaciondomiciliaria.data.remote.models.Usuarios;
import com.example.internaciondomiciliaria.domain.repository.UsuariosRepository;
import java.util.List;

public class UsuariosRepositoryImpl implements UsuariosRepository {
    private AppDatabase appDatabase;
    private ApiService apiService;
    private List<Usuarios> usuarios= null;

    public UsuariosRepositoryImpl() {
        this.apiService= new ApiService();
    }


    @Override
    public void getUsuarios(ApiCallback<List<Usuarios>> callback) {
        apiService.getUsuarios(new ApiCallback<List<Usuarios>>() {
            @Override
            public void onSuccess(List<Usuarios> response) {
                usuarios= response;
                callback.onSuccess(usuarios);
            }
            @Override
            public void onError(Throwable error) {
                Log.e("Salida ApiService Errror", "Error al obtener usuarios", error);
                callback.onError(error);
            }
        });
    }
}
