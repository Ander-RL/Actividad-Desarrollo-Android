package com.example.actividaddesarrollo_uf2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import kotlin.concurrent.thread

class MusicaPlayer : Service() {

    private val CANAL_ID = "canalNotificacionMusica"

    private var player: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer.create(this, R.raw.cancion)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val accion = intent?.getIntExtra("accion", 1)

        createNotificationChannel()

        val notificationIntent = Intent(this, Activity3::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification = NotificationCompat.Builder(this, CANAL_ID)
            .setContentTitle("Musica Foreground Service")
            .setContentText("Reproduciendo musica")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        player?.start()

        Thread {
            run {
                if (accion == 1) {
                    startMusic()
                }
                if (accion == 2){
                    stopMusic()
                }
                if (accion == 3){
                    sleepMusic()
                }
            }
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }

    fun startMusic(){
        if(player?.isPlaying == false) {
            player?.start()
        }
    }

    fun stopMusic(){
        if(player?.isPlaying == true)
        {
        player?.stop()
        player?.release()
        }
    }

    fun sleepMusic(){
        Thread.sleep(15000)
    }

    override fun onDestroy() {
        player?.stop()
        player?.release()
        stopSelf()
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not implemented")
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canalServicio = NotificationChannel(
                CANAL_ID, "Canal Servicio Musica",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(canalServicio)
        }
    }
}