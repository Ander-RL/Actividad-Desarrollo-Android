package com.example.actividaddesarrollo_uf2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity2.*

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        Toast.makeText(this, "Activity2", Toast.LENGTH_SHORT).show()
    }

    fun irActivity1(view: View) {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }

    fun crearTablas(view: View) {
        val intent = Intent(this, ActivityCrearTabla::class.java)
        startActivity(intent)
    }

    fun insertarDatos(view: View) {
        val intent = Intent(this, ActivityInsertarDatos::class.java)
        startActivityForResult(intent, 2)
    }

    fun mostrarDatos(view: View) {

        val nombreTabla = nombreTabla.text.toString()

        if (!nombreTabla.isEmpty()) {
            val tabla = SQLiteOpenHelperBD(this, "BBDD", null, 1)
            val bd = tabla.writableDatabase
            val fila = bd.rawQuery("SELECT * FROM $nombreTabla;", null)
            var imprimir = ""
            if (fila.moveToFirst()) {
                do {
                    imprimir += "\n" + fila.getString(0) + " " + fila.getString(1) + " " + fila.getString(2)
                } while (fila.moveToNext())
            }
            datosTabla.setText(imprimir)
            bd.close()
        }
    }
}
