package com.example.internaciondomiciliaria.ui.login;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.internaciondomiciliaria.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializar();
    }

    private void inicializar() {
        loginViewModel= new ViewModelProvider(this).get(LoginViewModel.class);
        //loginViewModel.onCreate();
        loginViewModel.getMensaje().observe(this, mensaje -> {
            binding.etMensaje.setText(mensaje);
            binding.etMensaje.setVisibility(View.VISIBLE);
        });
        binding.btLogin.setOnClickListener(view -> {
            binding.etMensaje.setVisibility(View.GONE);
            String correo= binding.etCorreo.getText().toString();
            String contrasenia= binding.etPassword.getText().toString();
            loginViewModel.iniciarSesion(correo,contrasenia);
        });
    }


}