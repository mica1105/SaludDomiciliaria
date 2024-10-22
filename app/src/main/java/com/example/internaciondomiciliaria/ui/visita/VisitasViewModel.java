package com.example.internaciondomiciliaria.ui.visita;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;
import com.example.internaciondomiciliaria.domain.usecase.GetVisitasUseCase;

import java.util.ArrayList;
import java.util.List;

public class VisitasViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<Visitas>> visitas;
    private MutableLiveData<List<String>> pacientes;
    private MutableLiveData<Integer> Vejecutas;
    private MutableLiveData<Integer> Vpendientes;
    private GetVisitasUseCase getVisitasUseCase;

    public VisitasViewModel() {
        getVisitasUseCase= new GetVisitasUseCase();
    }

    public LiveData<String> getText() {
        if (mText == null) {
            synchronized (this) {
                if (mText == null) {
                    mText = new MutableLiveData<>();
                }
            }
        }
        return mText;
    }
    public LiveData<List<Visitas>> getVisitas() {
        if (visitas == null) {
            synchronized (this){
                if (visitas == null) {
                    visitas = new MutableLiveData<>();
                }
            }
        }
        return visitas;
    }
    public LiveData<List<String>> getPacientes() {
        if (pacientes == null) {
            synchronized (this){
                if (pacientes == null) {
                    pacientes = new MutableLiveData<>();
                }
            }
        }
        return pacientes;
    }
    public LiveData<Integer> getVejecutas() {
        if (Vejecutas == null) {
            synchronized (this) {
                if (Vejecutas == null) {
                    Vejecutas = new MutableLiveData<>();
                }
            }
        }
        return Vejecutas;
    }
    public LiveData<Integer> getVpendientes() {
        if (Vpendientes == null) {
            synchronized (this) {
                if (Vpendientes == null) {
                    Vpendientes = new MutableLiveData<>();
                }
            }
        }
        return Vpendientes;
    }

    public void onCreate(Bundle bundle) {
        if(bundle!=null) {
            int id = bundle.getInt("usuarioId");
            if (id != 0) {
                obtenerListas(id);
            }
        } else {
            mText.postValue("No se encontraron datos");
        }
    }

    public void obtenerListas(int id) {
        getVisitasUseCase.execute( id,new ApiCallback<List<Visitas>>() {
            @Override
            public void onSuccess(List<Visitas> response) {
                visitas.postValue(response);
                List<String> lista= new ArrayList<>();
                int pendientes= 0;
                int ejecutadas= 0;
                for (Visitas visita : response) {
                    lista.add(visita.getPacientes());
                    if(visita.isEstado()){
                        ejecutadas++;
                    }else{
                        pendientes++;
                    }
                }
                Vejecutas.postValue(ejecutadas);
                Vpendientes.postValue(pendientes);
                pacientes.postValue(lista);
            }

            @Override
            public void onError(Throwable error) {
                mText.postValue(error.getMessage());
            }
        });
    }

}