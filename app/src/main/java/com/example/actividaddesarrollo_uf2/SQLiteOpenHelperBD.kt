package com.example.actividaddesarrollo_uf2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteOpenHelperBD(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version)  {

    private var nombreTabla: String = ""
    private var nombrePrimeryKey = ""
    private var descripcionProducto = ""
    private var precioProducto = 0.0

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $nombreTabla($nombrePrimeryKey int primary key, $descripcionProducto text, $precioProducto real)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun setnombreTabla(nombreTabla: String){
        this.nombreTabla = nombreTabla
    }

    fun setnombrePrimaryKey(nombrePrimeryKey: String){
        this.nombrePrimeryKey = nombrePrimeryKey
    }

    fun setdescripcionProducto(descripcionProducto: String){
        this.descripcionProducto = descripcionProducto
    }

    fun setprecioProducto(precioProducto: Double){
        this.precioProducto = precioProducto
    }
}