package com.example.taller1movil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Destinos : AppCompatActivity() {
    var arreglo:MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destinos)
        val list=findViewById<ListView>(R.id.Li)
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,arreglo)
        list.adapter=adapter
        val json= JSONObject(loadJSONFromAsset())
        val destinosJson = json.getJSONArray("destinos")
        val informacion= intent.getBundleExtra("info")
        for (i in 0 until destinosJson.length()){
            val jsonObject = destinosJson.getJSONObject(i)
            if (informacion?.getString("categoria")=="Todos") {
                arreglo.add(jsonObject.getString("nombre"))
            }else if(informacion?.getString("categoria")==jsonObject.getString("categoria")){
                arreglo.add(jsonObject.getString("nombre"))
            }
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