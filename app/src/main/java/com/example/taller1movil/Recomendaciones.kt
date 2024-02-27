package com.example.taller1movil

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Recomendaciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendaciones)
        val texto1 = findViewById<TextView>(R.id.text1)
        val texto2 = findViewById<TextView>(R.id.text2)
        val texto3 = findViewById<TextView>(R.id.text3)
        val texto4 = findViewById<TextView>(R.id.text4)
        val texto5 = findViewById<TextView>(R.id.text5)
        var arreglo = IntArray(5) { 0 }

        seleccionarRecomedaciones(arreglo, texto1, texto2, texto3, texto4, texto5)

    }

   fun seleccionarRecomedaciones(arreglo:IntArray, texto1:TextView, texto2:TextView, texto3:TextView, texto4:TextView, texto5:TextView,){
       MainActivity.arreglo1.forEach { bundle ->
           if (bundle.getString("categoria") == "Playas") {
               arreglo[0] = arreglo[0] + 1
           } else if (bundle.getString("categoria") == "Montañas") {
               arreglo[1] = arreglo[1] + 1
           } else if (bundle.getString("categoria") == "Ciudades Históricas") {
               arreglo[2] = arreglo[2] + 1
           } else if (bundle.getString("categoria") == "Maravillas del Mundo") {
               arreglo[3] = arreglo[3] + 1
           } else if (bundle.getString("categoria") == "Selvas") {
               arreglo[4] = arreglo[4] + 1
           }
       }
       var mayor = Int.MIN_VALUE
       var posicionMayor = -1
       for (i in arreglo.indices) {
           if (arreglo[i] > mayor) {
               mayor = arreglo[i]
               posicionMayor = i
           }
       }

       if (mayor == 0) {
           texto3.text = "N/A"
       } else {
           var categoria: String = ""

           if (posicionMayor == 0) {
               categoria = "Playas"
           }
           if (posicionMayor == 1) {
               categoria = "Montañas"
           }
           if (posicionMayor == 2) {
               categoria = "Ciudades Históricas"
           }
           if (posicionMayor == 3) {
               categoria = "Maravillas del Mundo"
           }
           if (posicionMayor == 4) {
               categoria = "Selvas"
           }

           var elementoAleatorio = MainActivity.arreglo1.random()
           var condicion: Boolean = false
           while (condicion == false) {

               if (elementoAleatorio.getString("categoria").toString() == categoria) {
                   texto1.text = elementoAleatorio.getString("nombre")
                   texto2.text = elementoAleatorio.getString("pais")
                   texto3.text = elementoAleatorio.getString("categoria")
                   texto4.text = elementoAleatorio.getString("plan")
                   texto5.text = "USD" + elementoAleatorio.getString("precio")
                   condicion = true
               } else {
                   elementoAleatorio = MainActivity.arreglo1.random()
               }
           }
       }
   }
}