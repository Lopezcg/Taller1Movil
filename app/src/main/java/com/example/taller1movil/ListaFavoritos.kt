package com.example.taller1movil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListaFavoritos : AppCompatActivity() {

    var arreglo2:MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_favoritos)
        initArray()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglo2)

        val listView: ListView = findViewById(R.id.Li1)
        listView.adapter = adapter
    }
    private fun initArray() {
        MainActivity.arreglo1.forEach { bundle ->
            arreglo2.add(bundle.getString("nombre").toString())
        }
    }
}