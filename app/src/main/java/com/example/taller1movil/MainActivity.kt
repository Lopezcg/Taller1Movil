package com.example.taller1movil

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.MediaController
import android.widget.Spinner
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BTN1 = findViewById<Button>(R.id.button1)
        val BTN2 = findViewById<Button>(R.id.button2)
        val BTN3 = findViewById<Button>(R.id.button3)
        val spinner=findViewById<Spinner>(R.id.spinner1)
        val intent= Intent(this,Destinos::class.java)
        val bundle=Bundle()
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val categoriaSeleccionada = parent?.getItemAtPosition(position).toString()
                bundle.putString("categoria", categoriaSeleccionada)

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback.
            }
        }
        intent.putExtra("info",bundle)
        BTN1.setOnClickListener{
            startActivity(intent)
        }
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