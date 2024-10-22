package com.example.internaciondomiciliaria.data.remote;

import android.util.Log;
import android.widget.Toast;

import com.example.internaciondomiciliaria.data.remote.models.Usuarios;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiService {

    private final ApiClient apiClient;
    public ApiService() {
        ApiClient apiClient = RetrofitClient.getApi();
        this.apiClient = apiClient;
    }

    public void getUsuarios(final ApiCallback<List<Usuarios>> callback) {
        Call<List<Usuarios>> call = apiClient.getUsuarios();
        call.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                if(response.isSuccessful()){
                    List<Usuarios> usuarios = response.body();
                    if (usuarios != null) {
                        callback.onSuccess(usuarios); // Devuelve la lista de usuarios
                    } else {
                        callback.onError(new Exception("No se encontraron usuarios"));
                    }
                } else {
                    callback.onError(new Exception("Error al obtener usuarios: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public void getVisitas(int id,final ApiCallback<List<Visitas>> callback){
        Call<List<Visitas>> call = apiClient.getVisitas(id);
        call.enqueue(new Callback<List<Visitas>>() {
            @Override
            public void onResponse(Call<List<Visitas>> call, Response<List<Visitas>> response) {
                if(response.isSuccessful()) {
                    List<Visitas> visitas = response.body();
                    if (visitas != null) {
                        callback.onSuccess(visitas); // Devuelve la lista de visitas
                    } else {
                        callback.onError(new Exception("No se encontraron visitas"));
                    }
                } else{
                    callback.onError(new Exception("Error al obtener visitas: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Visitas>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }


}
