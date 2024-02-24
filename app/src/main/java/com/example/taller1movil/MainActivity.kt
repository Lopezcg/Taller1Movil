package com.example.taller1movil

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        val videoView = findViewById<VideoView>(R.id.videoview)
        val uri = Uri.parse("https://v1.pinimg.com/videos/mc/720p/5f/54/c1/5f54c1e83c67bcb239c6c0c7484d8e12.mp4")
        videoView.setVideoURI(uri)
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Reproducir en bucle
            val videoWidth = mediaPlayer.videoWidth.toFloat()
            val videoHeight = mediaPlayer.videoHeight.toFloat()
            val videoProportion = videoWidth / videoHeight

            val screenWidth = resources.displayMetrics.widthPixels.toFloat()
            val screenHeight = resources.displayMetrics.heightPixels.toFloat()
            val screenProportion = screenWidth / screenHeight

            val layoutParams = videoView.layoutParams
            if (videoProportion > screenProportion) {
                layoutParams.width = screenWidth.toInt()
                layoutParams.height = (screenWidth / videoProportion).toInt()
            } else {
                layoutParams.width = (videoProportion * screenHeight).toInt()
                layoutParams.height = screenHeight.toInt()
            }
            videoView.layoutParams = layoutParams
        }
        videoView.requestFocus()
        videoView.start()*/
    }
}