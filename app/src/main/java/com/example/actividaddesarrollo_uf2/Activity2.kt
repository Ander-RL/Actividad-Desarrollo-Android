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

    private var id = 0
    private var nombre = ""
    private var direc = ""
    private var codPost = 0
    private var numTelf = 0
    private var texto = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        Toast.makeText(this, "Activity2", Toast.LENGTH_SHORT).show()


    }

    fun irActivity1(view: View) {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }

    fun crearTabla(view: View) {
        nombreTabla.text = "Tabla Clientes creada"
    }

    fun insertarDatos(view: View) {
        val intent = Intent(this, ActivityInsertarDatos::class.java)
        startActivityForResult(intent, 2)
    }

    fun mostrarDatos(view: View) {

        Thread {
            val cliente = ClientesEntity(id, nombre, direc, codPost, numTelf)
            val db =
                Room.databaseBuilder(applicationContext, ClientesDB::class.java, "clientes.db")
                    .build()
            db.clientesDao.nuevoCliente(cliente)

            db.clientesDao.getClientes().forEach {
                //datosTabla.text =
                    texto += ("\n" + it.id.toString() + it.nombre.toString() + it.direccion.toString() + it.codPostal.toString() + it.numTelf.toString())
            }
            datosTabla.text = texto
        }.start()
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = getSharedPreferences("tablaNombreDatos", Context.MODE_PRIVATE)
        id = sharedPref.getInt("id", 0)
        nombre = sharedPref.getString("nombre", "").toString()
        direc = sharedPref.getString("direc", "").toString()
        codPost = sharedPref.getInt("codPost", 0)
        numTelf = sharedPref.getInt("numTelf", 0)

    }
}
