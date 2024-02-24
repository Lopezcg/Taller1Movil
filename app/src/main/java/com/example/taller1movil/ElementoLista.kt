package com.example.taller1movil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ElementoLista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elemento_lista)
        val texto1=findViewById<TextView>(R.id.text1)
        val texto2=findViewById<TextView>(R.id.text2)
        val texto3=findViewById<TextView>(R.id.text3)
        val texto4=findViewById<TextView>(R.id.text4)
        val texto5=findViewById<TextView>(R.id.text5)
        val destino=intent.getBundleExtra("Destino")
        texto1.text=destino?.getString("nombre")
        texto2.text=destino?.getString("pais")
        texto3.text=destino?.getString("categoria")
        texto4.text=destino?.getString("plan")
        texto5.text="USD" + destino?.getString("precio")
    }
}