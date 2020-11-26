package com.example.actividaddesarrollo_uf2

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity2.*
import kotlinx.android.synthetic.main.activity_insertar_datos.*

class ActivityInsertarDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_insertar_datos)

    }

    fun volverActivity2(view: View) {
        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    fun insertarDB(view: View) {
        if (inputCheck()) {

            val nombreTabla = editTextNombreTabla.text.toString()
            val codigo = editTextCodigo.text.toString().toInt()
            val descripcion = editTextDescripcion.text.toString()
            val precio = editTextPrecio.text.toString().toDouble()

            val tabla = SQLiteOpenHelperBD(this, "BBDD", null, 1)
            val bd = tabla.writableDatabase
            val registro = ContentValues()
            registro.put("codigo", codigo)
            registro.put("descripcion", descripcion)
            registro.put("precio", precio)
            bd.insert(nombreTabla, null, registro)
            bd.close()

            editTextNombreTabla.setText("")
            editTextCodigo.setText("")
            editTextDescripcion.setText("")
            editTextPrecio.setText("")

        } else {
            Toast.makeText(this, getString(R.string.insertarDatos_Toast), Toast.LENGTH_LONG).show()
        }
    }

    fun inputCheck(): Boolean {
        return !(editTextNombreTabla.text.isEmpty() &&
                editTextCodigo.text.isEmpty() &&
                editTextDescripcion.text.isEmpty() &&
                editTextPrecio.text.isEmpty())
    }
}