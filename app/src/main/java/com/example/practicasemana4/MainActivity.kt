package com.example.practicasemana4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var conocerPais:String = ""
    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listViewExample()
        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            //Toast.makeText(this@MainActivity, "Entramos o que pex", Toast.LENGTH_SHORT).show()
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val resultado = data?.getStringExtra("resultado")
                Toast.makeText(this@MainActivity, "Resultado: $resultado", Toast.LENGTH_SHORT).show()
            }
            // Hacer algo con el resultado recibido de Activity

        }
    }

    fun abrirActivity2(){
        val pais = conocerPais
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("pais", pais)
        startForResult.launch(intent)
    }




    fun listViewExample(){
        val nombres = resources.getStringArray(R.array.paises)
        val listView: ListView = findViewById(R.id.lvPaises)

        // Crea un ArrayAdapter para mostrar los nombres en el ListVie
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres)

        // Asocia el ArrayAdapter con el ListView
        listView.adapter = adapter

        // Configura un escuchador para el clic en los elementos del ListView
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val nombreSeleccionado = nombres[position]
                // Muestra un Toast con el nombre seleccionado
                //Toast.makeText(this@MainActivity, "Nombre seleccionado: $nombreSeleccionado", Toast.LENGTH_SHORT).show()
                conocerPais = nombreSeleccionado
                abrirActivity2();
            }
        }

    }

}