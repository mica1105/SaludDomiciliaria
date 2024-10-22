package com.example.internaciondomiciliaria.domain.usecase;


import android.util.Log;

import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.models.Usuarios;
import com.example.internaciondomiciliaria.data.repository.UsuariosRepositoryImpl;
import com.example.internaciondomiciliaria.domain.repository.UsuariosRepository;

import java.util.List;

public class GetUsuariosUseCase {
    private UsuariosRepositoryImpl usuariosRepository;
    private Usuarios usuarioObtenido;

    public GetUsuariosUseCase() {
        this.usuariosRepository = new UsuariosRepositoryImpl();
    }

    public void execute(ApiCallback<Usuarios> callback) {
        usuariosRepository.getUsuarios(new ApiCallback<List<Usuarios>>() {
            @Override
            public void onSuccess(List<Usuarios> response) {
                if (!response.isEmpty()) {
                    Usuarios usuarioSeleccionado = response.get(0);
                    callback.onSuccess(usuarioSeleccionado); // Pasar al callback original
                } else {
                    // Manejar respuesta vacía,tal vez llamar a onError con un error específico
                    callback.onError(new NullPointerException("No se encontraron usuarios"));
                }
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error); // Propagar error al callback original
                Log.e("GetUsuariosUseCase", "Error al obtener usuarios", error);
            }
        });
    }
}
