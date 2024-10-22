package com.example.internaciondomiciliaria.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> mensaje;
    private MutableLiveData<Integer> usuarioId;

    public MutableLiveData<String> getMensaje() {
        if (mensaje == null) {
            synchronized (this) {
                if (mensaje == null) {
                    mensaje = new MutableLiveData<>();
                }
            }
        }
        return mensaje;
    }

    public MutableLiveData<Integer> getUsuarioId() {
        if (usuarioId == null) {
            synchronized (this) {
                if (usuarioId == null) {
                    usuarioId = new MutableLiveData<>();
                }
            }
        }
        return usuarioId;
    }

    public void setUsuarioId(int id) {
        if(id != 0) {
            usuarioId.setValue(id);
        }
        else {
            mensaje.postValue("Los datos del usuario no se han cargado correctamente");
        }
    }
}
