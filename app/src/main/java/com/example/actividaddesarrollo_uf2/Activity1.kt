package com.example.actividaddesarrollo_uf2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)
    }

    fun irActivity2(view: View) {
        val intent: Intent = Intent(this, Activity2::class.java)
        startActivity(intent)
    }
    fun irActivity3(view: View) {
        val intent: Intent = Intent(this, Activity3::class.java)
        startActivity(intent)
    }
}