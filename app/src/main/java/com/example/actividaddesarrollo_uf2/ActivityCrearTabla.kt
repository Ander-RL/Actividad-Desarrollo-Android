package com.example.actividaddesarrollo_uf2

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_crear_tabla.*

class ActivityCrearTabla : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_tabla)
    }

    fun crearTabla(view: View) {

        var nombreTabla: String = editTextNombreTabla.text.toString()
        var nombrePrimeryKey: String = editTextCodigo.text.toString()
        var descripcionProducto: String = editTextDescripcion.text.toString()
        var precioProducto: String = editTextPrecio.text.toString()

        if (inputCheck()) {
            val tabla = SQLiteOpenHelperBD(this, "BBDD", null, 1)
            val bd = tabla.writableDatabase
            bd.execSQL("CREATE TABLE IF NOT EXISTS $nombreTabla (codigo INT PRIMARY KEY, descripcion TEXT, precio DOUBLE);")
            //val creacion = ContentValues()
            //tabla.setnombreTabla(nombreTabla)
            //tabla.setnombrePrimaryKey(nombrePrimeryKey)
            //tabla.setnombreDescripcion(descripcionProducto)
            //tabla.setnombrePrecio(precioProducto)

            Toast.makeText(this, "Se creó la tabla", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.insertarDatos_Toast), Toast.LENGTH_LONG).show()
        }
    }

    fun volverActivity2(view: View) {
        editTextNombreTabla.setText("")
        editTextCodigo.setText("")
        editTextDescripcion.setText("")
        editTextPrecio.setText("")

        val intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }

    fun inputCheck(): Boolean {
        return !(editTextNombreTabla.text.isEmpty() &&
                editTextCodigo.text.isEmpty() &&
                editTextDescripcion.text.isEmpty() &&
                editTextPrecio.text.isEmpty())
    }
}