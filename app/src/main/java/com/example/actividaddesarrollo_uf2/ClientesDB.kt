package com.example.actividaddesarrollo_uf2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ClientesEntity::class], version = 1, exportSchema = false)
abstract class ClientesDB: RoomDatabase() {

    abstract val clientesDao: ClientesDao

    companion object{
        private const val NOMBRE_DB = "clientes.db"
        fun buildDefault(context: Context) = Room.databaseBuilder(context,ClientesDB::class.java, NOMBRE_DB).fallbackToDestructiveMigration().build()
    }
}