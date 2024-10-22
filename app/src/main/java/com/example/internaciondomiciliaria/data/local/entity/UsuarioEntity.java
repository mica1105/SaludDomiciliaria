package com.example.internaciondomiciliaria.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios")
public class UsuarioEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="email")
    public String email;
    @ColumnInfo(name="password")
    public String password;
}
