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
import android.widget.TextView
import android.widget.VideoView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() ,AdapterView.OnItemSelectedListener{

    companion object {
        val bundle = Bundle()
        var arreglo1:MutableList<Bundle> = ArrayList()
    }

    var categoriaSeleccionada: String = "Todos"
    var bundle: Bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val BTN1 = findViewById<Button>(R.id.button1)
        val BTN2 = findViewById<Button>(R.id.button2)
        val BTN3 = findViewById<Button>(R.id.button3)
        val spinner=findViewById<Spinner>(R.id.spinner1)
        val intent= Intent(this,Destinos::class.java)
        val intent1= Intent(this, ListaFavoritos::class.java)
        val intent2= Intent(this, Recomendaciones::class.java)
        spinner.onItemSelectedListener = this
        bundle.putString("categoria", categoriaSeleccionada)
        intent.putExtra("info",bundle)
        BTN1.setOnClickListener{
            startActivity(intent) }
        BTN2.setOnClickListener{
            startActivity(intent1) }
        BTN3.setOnClickListener{
            startActivity(intent2) }
    }
     override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,

        id: Long
    ) {
         categoriaSeleccionada = parent?.getItemAtPosition(position).toString()
         bundle.putString("categoria", categoriaSeleccionada)

    }
     override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback.
    }

}