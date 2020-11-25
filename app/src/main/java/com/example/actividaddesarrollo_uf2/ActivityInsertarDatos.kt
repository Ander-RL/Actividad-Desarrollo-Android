package com.example.actividaddesarrollo_uf2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_insertar_datos.*

class ActivityInsertarDatos : AppCompatActivity() {

    //private val dao = ClientesDB.buildDefault(application).clienteDao

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
            val id = editTextId.text.toString().toInt()
            val nombre = editTextNombre.text.toString()
            val direc = editTextDireccion.text.toString()
            val codPost = editTextCodPostal.text.toString().toInt()
            val numTelf = editTextNumTelf.text.toString().toInt()

            val sharedPref = getSharedPreferences("tablaNombreDatos", Context.MODE_PRIVATE)

            sharedPref.edit().putInt("id", id).apply()
            sharedPref.edit().putString("nombre", nombre).apply()
            sharedPref.edit().putString("direc", direc).apply()
            sharedPref.edit().putInt("codPost", codPost).apply()
            sharedPref.edit().putInt("numTelf", numTelf).apply()

        } else {
            Toast.makeText(this, getString(R.string.insertarDatos_Toast), Toast.LENGTH_LONG).show()
        }


    }

    fun inputCheck(): Boolean {
        return !(editTextId.text.isEmpty() &&
                editTextNombre.text.isEmpty() &&
                editTextDireccion.text.isEmpty() &&
                editTextCodPostal.text.isEmpty() &&
                editTextNumTelf.text.isEmpty())
    }
}