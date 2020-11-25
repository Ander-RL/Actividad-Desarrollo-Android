package com.example.actividaddesarrollo_uf2

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Activity3 : AppCompatActivity() {

    //private var player: MediaPlayer = MediaPlayer.create(this, R.raw.cancion)
    //val reproductor = MusicaPlayer()
    private var accion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity3)

    }

    fun playMusic(view: View) {
        accion = 1
        //MusicaPlayer().playMusic()
        //reproductor.playMusic()
        //player.start()
        //player.setOnCompletionListener { stopMusic(view) }
    }

    fun stopMusic(view: View) {
        accion = 2
        //MusicaPlayer().stopMusic()
        //reproductor.stopMusic()
        //stopPlayer()
    }

    fun pauseMusic(view: View) {
        accion = 3
    }

    fun stopService(view: View) {
        Toast.makeText(this,"pararServicio", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MusicaPlayer::class.java)
        stopService(intent)
    }

    fun crearServicio(view: View) {
        //Toast.makeText(this,"crearServicio", Toast.LENGTH_LONG).show()
        if (accion == 1) {
            val intent = Intent(this, MusicaPlayer::class.java)
            intent.putExtra("accion", 1)
            startService(intent)
        }
        if (accion == 2) {
            Intent(this, MusicaPlayer::class.java).also {
                intent.putExtra("accion", 2)
                startService(intent)
            }
        }
        if (accion == 3) {
            Intent(this, MusicaPlayer::class.java).also {
                intent.putExtra("accion", 3)
                startService(intent)
            }
        }
    }

    fun volverActivity1(view: View) {
        val intent = Intent(this, Activity1::class.java)
        startActivity(intent)
    }
}