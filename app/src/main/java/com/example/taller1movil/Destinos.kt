package com.example.taller1movil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Destinos : AppCompatActivity() {
    var arreglo:MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinos)
        val list = findViewById<ListView>(R.id.Li)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglo)
        list.adapter = adapter
        val json = JSONObject(loadJSONFromAsset())
        val destinosJson = json.getJSONArray("destinos")
        val informacion = intent.getBundleExtra("info")

        llenarDestinos(list, adapter, json, destinosJson, informacion)
    }

    fun llenarDestinos(list: ListView, adapter: ArrayAdapter<String>, json:JSONObject, destinosJson:JSONArray, informacion: Bundle?){
        var i = 0
        for (i in 0 until destinosJson.length()){
            val jsonObject = destinosJson.getJSONObject(i)
            if (informacion?.getString("categoria")=="Todos") {
                arreglo.add(jsonObject.getString("nombre"))
            }else if(informacion?.getString("categoria")==jsonObject.getString("categoria")){
                arreglo.add(jsonObject.getString("nombre"))
            }
        }

        list.setOnItemClickListener { parent, view, position, id ->
           if(informacion?.getString("categoria")=="Montañas"){
                i = 3
            }
            else if(informacion?.getString("categoria")=="Ciudades Históricas"){
                i = 6
            }
            else if(informacion?.getString("categoria")=="Maravillas del Mundo"){
                i = 9
            }
            else if(informacion?.getString("categoria")=="Selvas"){
                i = 12
            }
            val jsonObject = destinosJson.getJSONObject(position+i)
            val intent = Intent(this, ElementoLista::class.java)
            val bundle = Bundle().apply {
                putString("nombre", jsonObject.getString("nombre"))
                putString("pais", jsonObject.getString("pais"))
                putString("categoria", jsonObject.getString("categoria"))
                putString("plan", jsonObject.getString("plan"))
                putString("precio", jsonObject.getString("precio"))
            }
            intent.putExtra("Destino", bundle)
            startActivity(intent)
        }
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val isStream: InputStream =assets.open("destinos.json")
            val size:Int=isStream.available()
            val buffer = ByteArray(size)
            isStream.read(buffer)
            isStream.close()
            json= String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}