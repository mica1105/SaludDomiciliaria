package com.example.internaciondomiciliaria.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.internaciondomiciliaria.data.local.entity.UsuarioEntity;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    List<UsuarioEntity> getAllUsers();
}
