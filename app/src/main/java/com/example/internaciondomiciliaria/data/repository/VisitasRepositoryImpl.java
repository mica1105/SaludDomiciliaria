package com.example.internaciondomiciliaria.data.repository;

import android.util.Log;

import com.example.internaciondomiciliaria.data.local.AppDatabase;
import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.ApiService;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;
import com.example.internaciondomiciliaria.domain.repository.VisitasRepository;

import java.util.List;

public class VisitasRepositoryImpl implements VisitasRepository {
    private AppDatabase appDatabase;
    private ApiService apiService;
    private List<Visitas> visitas= null;

    public VisitasRepositoryImpl() {
        this.apiService= new ApiService();
    }

    @Override
    public void getVisitas(int id, ApiCallback<List<Visitas>> callback) {
        apiService.getVisitas(id, new ApiCallback<List<Visitas>>(){

            @Override
            public void onSuccess(List<Visitas> response) {
                visitas= response;
                callback.onSuccess(visitas);
            }

            @Override
            public void onError(Throwable error) {
                Log.e("Salida ApiService Errror", "Error al obtener visitas", error);
                callback.onError(error);
            }
        });
    }
}
