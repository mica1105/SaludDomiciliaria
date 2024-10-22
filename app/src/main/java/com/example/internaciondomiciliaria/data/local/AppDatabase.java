package com.example.internaciondomiciliaria.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.internaciondomiciliaria.data.local.dao.UsuarioDao;
import com.example.internaciondomiciliaria.data.local.entity.UsuarioEntity;

@Database(entities = {UsuarioEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();
}
