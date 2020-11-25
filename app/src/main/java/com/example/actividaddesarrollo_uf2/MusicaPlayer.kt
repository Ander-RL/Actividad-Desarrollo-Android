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

class MusicaPlayer : Service() {

    private val CANAL_ID = "canalNotificacionMusica"

    private val player: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val accion = intent?.getIntExtra("accion", 1)

        Toast.makeText(this,"Servicio Iniciado", Toast.LENGTH_LONG).show()

        val player: MediaPlayer = MediaPlayer.create(this, R.raw.cancion)

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

        Thread {
            run {
                if (accion == 1) {
                    player.start()
                }
                if (accion == 2){
                    player.stop()
                    player.release()
                }
                if (accion == 3){
                    player.pause()
                }
            }
        }.start()

        //return START_NOT_STICKY
        return super.onStartCommand(intent, flags, startId)
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