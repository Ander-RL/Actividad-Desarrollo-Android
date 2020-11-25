package com.example.actividaddesarrollo_uf2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClientesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun nuevoCliente(cliente: ClientesEntity)

    @Query("SELECT * FROM tabla_clientes ORDER BY id ASC")
    fun getClientes(): List<ClientesEntity>

    @Query("DELETE FROM tabla_clientes")
    fun eliminarClientes()
}