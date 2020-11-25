package com.example.actividaddesarrollo_uf2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteOpenHelperBD(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version)  {

    private var nombreTabla = ""
    private var nombrePrimeryKey = ""
    private var nombreDescripcion = ""
    private var nombrePrecio = ""


    override fun onCreate(db: SQLiteDatabase?) {
        //db?.execSQL("create table $nombreTabla($nombrePrimeryKey int primary key, $nombreDescripcion text, $nombrePrecio real)")
        //db?.execSQL("create table $nombreTabla(codigo int primary key, descripcion text, precio double)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        //db?.execSQL("update table $nombreTabla($nombrePrimeryKey int primary key, $nombreDescripcion text, $nombrePrecio real)")
    }

    fun setnombreTabla(nombreTabla: String){
        this.nombreTabla = nombreTabla
    }

    /*fun setnombrePrimaryKey(nombrePrimeryKey: String){
        this.nombrePrimeryKey = nombrePrimeryKey
    }

    fun setnombreDescripcion(nombreDescripcion: String){
        this.nombreDescripcion = nombreDescripcion
    }

    fun setnombrePrecio(nombrePrecio: String){
        this.nombrePrecio = nombrePrecio
    }*/
}