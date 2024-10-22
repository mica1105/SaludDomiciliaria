package com.example.internaciondomiciliaria.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.ApiClient;
import com.example.internaciondomiciliaria.data.remote.ApiService;
import com.example.internaciondomiciliaria.data.remote.RetrofitClient;
import com.example.internaciondomiciliaria.data.remote.models.Usuarios;
import com.example.internaciondomiciliaria.domain.usecase.GetUsuariosUseCase;
import com.example.internaciondomiciliaria.ui.main.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends AndroidViewModel {

    private Context context;
    private GetUsuariosUseCase getUsuariosUseCase;
    private MutableLiveData<String> mensaje;
    //private ApiService apiService;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
        //apiService= new ApiService();
        getUsuariosUseCase= new GetUsuariosUseCase();
    }

    public LiveData<String> getMensaje(){
        if(mensaje==null){
            synchronized (this) { // Bloquear para la sincronización
                if (mensaje == null) {
                    mensaje = new MutableLiveData<>();
                }
            }
        }
        return mensaje;
    }

    public void iniciarSesion(String correo, String contrasenia){
        if (correo.isEmpty() || contrasenia.isEmpty()){
            mensaje.postValue("Usuario o contraseña son requeridos");
        } else {
            getUsuariosUseCase.execute(new ApiCallback<Usuarios>() {
                @Override
                public void onSuccess(Usuarios response) {
                    if (response != null) {
                        if(response.getEmail().equals(correo) && response.getPassword().equals(contrasenia)) {
                            Intent intent = new Intent(context, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("usuarioId", response.getId());
                            context.startActivity(intent);
                            //Toast.makeText(context, "Bienvenido " + response.getEmail(), Toast.LENGTH_LONG).show();
                        } else {
                            mensaje.postValue("Usuario o contraseña incorrectos");
                        }
                    }
                }

                @Override
                public void onError(Throwable error) {
                    mensaje.postValue("Error: "+ error.getMessage());
                }
            });
        }
    }
}
