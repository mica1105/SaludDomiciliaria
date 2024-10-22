package com.example.internaciondomiciliaria.data.remote;

import com.example.internaciondomiciliaria.data.remote.models.Usuarios;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {
    @GET("usuriarios")
    Call<List<Usuarios>> getUsuarios();
    @GET("usuriarios/{id}/visitas")
    Call<List<Visitas>> getVisitas(@Path("id") int id);
}
