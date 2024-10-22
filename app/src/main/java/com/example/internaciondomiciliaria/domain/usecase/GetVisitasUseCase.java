package com.example.internaciondomiciliaria.domain.usecase;

import android.util.Log;

import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;
import com.example.internaciondomiciliaria.data.repository.VisitasRepositoryImpl;

import java.util.List;

public class GetVisitasUseCase {
    private VisitasRepositoryImpl visitasRepository;
    private List<Visitas> visitasObtenidas;

    public GetVisitasUseCase() {
        this.visitasRepository = new VisitasRepositoryImpl();
    }

    public void execute(int id, ApiCallback<List<Visitas>> callback) {
        visitasRepository.getVisitas(id, new ApiCallback<List<Visitas>>(){

            @Override
            public void onSuccess(List<Visitas> response) {
                if (!response.isEmpty()) {
                    visitasObtenidas = response;
                    callback.onSuccess(visitasObtenidas);
                } else {
                    callback.onError(new NullPointerException("No se encontraron visitas"));
                }
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error);
                Log.e("GetVisitasUseCase", "Error al obtener visitas", error);
            }
        });
    }
}
