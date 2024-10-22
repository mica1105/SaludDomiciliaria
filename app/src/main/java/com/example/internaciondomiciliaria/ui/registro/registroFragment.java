package com.example.internaciondomiciliaria.ui.registro;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.internaciondomiciliaria.R;
import com.example.internaciondomiciliaria.databinding.FragmentRegistroBinding;

public class registroFragment extends Fragment {

    private RegistroViewModel mViewModel;
    private FragmentRegistroBinding binding;

    public static registroFragment newInstance() {
        return new registroFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        inicializar(root);
        return root;
    }

    public void inicializar(View root){
        mViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
        Bundle bundle= getArguments();
        if(bundle!=null){
            int id = bundle.getInt("id");
            String paciente = bundle.getString("paciente");
            binding.etPaciente.setText(paciente);
            binding.etPractica.setText("Enfermeria");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}