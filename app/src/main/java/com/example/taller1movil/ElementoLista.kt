package com.example.taller1movil

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ElementoLista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elemento_lista)
        val texto1=findViewById<TextView>(R.id.text1)
        val texto2=findViewById<TextView>(R.id.text2)
        val texto3=findViewById<TextView>(R.id.text3)
        val texto4=findViewById<TextView>(R.id.text4)
        val texto5=findViewById<TextView>(R.id.text5)
        val boton=findViewById<Button>(R.id.button1)
        val destino=intent.getBundleExtra("Destino")
        texto1.text=destino?.getString("nombre")
        val nombre = destino?.getString("nombre")
        texto2.text=destino?.getString("pais")
        val pais = destino?.getString("pais")
        texto3.text=destino?.getString("categoria")
        val categoria = destino?.getString("categoria")
        texto4.text=destino?.getString("plan")
        val plan = destino?.getString("plan")
        texto5.text="USD" + destino?.getString("precio")
        val precio = destino?.getString("precio")

        boton.setOnClickListener{
            boton.isEnabled = false
            val bundle = Bundle().apply {
                putString("nombre", nombre)
                putString("pais", pais)
                putString("categoria", categoria)
                putString("plan", plan)
                putString("precio", precio)
            }
            MainActivity.arreglo1.add(bundle)
            val toast = Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER or Gravity.TOP, 0, 900)
            toast.show()
        }


    }
}