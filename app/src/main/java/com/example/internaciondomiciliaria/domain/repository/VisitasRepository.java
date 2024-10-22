package com.example.internaciondomiciliaria.domain.repository;

import com.example.internaciondomiciliaria.data.remote.ApiCallback;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;

import java.util.List;

public interface VisitasRepository {
    void getVisitas(int id, ApiCallback<List<Visitas>> callback);
}
