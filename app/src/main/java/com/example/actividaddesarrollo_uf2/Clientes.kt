package com.example.actividaddesarrollo_uf2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_clientes")
data class ClientesEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val direccion: String,
    val codPostal: Int,
    val numTelf: Int
)