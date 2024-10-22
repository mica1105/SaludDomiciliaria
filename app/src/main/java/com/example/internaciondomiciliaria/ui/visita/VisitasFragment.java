package com.example.internaciondomiciliaria.ui.visita;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.internaciondomiciliaria.R;
import com.example.internaciondomiciliaria.databinding.FragmentVisitasBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class VisitasFragment extends Fragment {

    private FragmentVisitasBinding binding;
    private VisitasViewModel visitasViewModel;
    private VisitasAdapter adapter;
    private Context context;
    private final Calendar c = Calendar.getInstance();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentVisitasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();
        inicializar(root);

        return root;
    }

    private void inicializar(View root) {
        visitasViewModel =
                new ViewModelProvider(this).get(VisitasViewModel.class);
        Bundle bundle = getArguments();
        visitasViewModel.getText().observe(getViewLifecycleOwner(), mensaje -> {
            Toast.makeText(getContext(), mensaje, Toast.LENGTH_LONG).show();
        });
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        binding.etFechaDesde.setOnClickListener(v1->{
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    context,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        String fechaFormateada = dateFormat.format(calendar.getTime());
                        binding.etFechaDesde.setText(fechaFormateada);
                    }, anio, mes, dia);
            datePickerDialog.show();
        });
        binding.etFechaHasta.setOnClickListener(v1->{
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    context,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, monthOfYear, dayOfMonth);
                        String fechaFormateada = dateFormat.format(calendar.getTime());
                        binding.etFechaHasta.setText(fechaFormateada);
                    }, anio, mes, dia);
            datePickerDialog.show();
        });
        visitasViewModel.getVisitas().observe(getViewLifecycleOwner(), visitas -> {
            Log.d("Visitas son con :", visitas.get(0).getPacientes() +" y "+ visitas.get(1).getPacientes());
            GridLayoutManager layoutManager = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
            binding.rvListaVisitas.setLayoutManager(layoutManager);
            adapter= new VisitasAdapter(context, visitas);
            binding.rvListaVisitas.setAdapter(adapter);
        });
        visitasViewModel.getPacientes().observe(getViewLifecycleOwner(), pacientes -> {
            List<String> items = new ArrayList<>();
            items.add("Todos los Pacientes");
            items.addAll(pacientes);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, items);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            binding.spinnerPacientes.setAdapter(adapter);
        });
        visitasViewModel.getVejecutas().observe(getViewLifecycleOwner(), ejecutas -> {
            binding.etEjecutadas.setText(String.valueOf(ejecutas));
        });
        visitasViewModel.getVpendientes().observe(getViewLifecycleOwner(), pendientes -> {
            binding.etPendientes.setText(String.valueOf(pendientes));
        });
        visitasViewModel.onCreate(bundle);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}