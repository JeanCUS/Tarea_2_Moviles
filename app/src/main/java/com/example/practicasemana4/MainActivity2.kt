package com.example.practicasemana4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity2 : AppCompatActivity() {

    var paisSeleccionado = ""
    var infopais = ""
    //var miArreglo = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val pais = intent.getStringExtra("pais")
        paisSeleccionado=pais.toString()
        //Toast.makeText(this@MainActivity2, "pais: $pais", Toast.LENGTH_SHORT).show()
        spinnerExample()
    }

    val diccionarioCostaRica: Map<String, String> = mapOf(
        "5.1 millones" to "Poblacion",
        "51,100 kilómetros cuadrados" to "Territorio"
    )
    val diccionarioElSalvador: Map<String, String> = mapOf(
        "6.4 millones" to "Poblacion",
        "21,041 kilómetros cuadrados" to "Territorio"
    )
    val diccionarioHonduras: Map<String, String> = mapOf(
        "18.2 millones" to "Poblacion",
        "108,889 kilómetros cuadrados" to "Territorio"
    )
    val diccionarioNicaragua: Map<String, String> = mapOf(
        "6.9 millones" to "Poblacion",
        "130,373 kilómetros cuadrados/2" to "Territorio"
    )
    val diccionarioGuatemala: Map<String, String> = mapOf(
        "18.2 millones" to "Poblacion",
        "108,889 kilómetros cuadrados" to "Territorio"
    )

    fun brindarInformacion(view:View){
        if(paisSeleccionado=="Costa Rica"){
            for ((valor, clave) in diccionarioCostaRica) {
                if(clave==infopais){
                    val resultado = "El usuario quiso observar cuanto(a) $clave posee $paisSeleccionado, este posee $valor."
                    val intent = Intent()
                    intent.putExtra("resultado", resultado)
                    setResult(Activity.RESULT_OK, intent)
                    //Toast.makeText(this@MainActivity2, "pais: $resultado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }else if(paisSeleccionado=="Nicaragua") {
            for ((valor, clave) in diccionarioNicaragua) {
                if (clave == infopais) {
                    val resultado =
                        "El usuario quiso observar cuanto(a) $clave posee $paisSeleccionado, este posee $valor."
                    val intent = Intent()
                    intent.putExtra("resultado", resultado)
                    setResult(Activity.RESULT_OK, intent)
                    //Toast.makeText(this@MainActivity2, "pais: $resultado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }else if(paisSeleccionado=="El Salvador") {
            for ((valor, clave) in diccionarioElSalvador) {
                if (clave == infopais) {
                    val resultado =
                        "El usuario quiso observar cuanto(a) $clave posee $paisSeleccionado, este posee $valor."
                    val intent = Intent()
                    intent.putExtra("resultado", resultado)
                    setResult(Activity.RESULT_OK, intent)
                    //Toast.makeText(this@MainActivity2, "pais: $resultado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }else if(paisSeleccionado=="Honduras") {
            for ((valor, clave) in diccionarioHonduras) {
                if (clave == infopais) {
                    val resultado =
                        "El usuario quiso observar cuanto(a) $clave posee $paisSeleccionado, este posee $valor."
                    val intent = Intent()
                    intent.putExtra("resultado", resultado)
                    setResult(Activity.RESULT_OK, intent)
                    //Toast.makeText(this@MainActivity2, "pais: $resultado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }else if(paisSeleccionado=="Guatemala") {
            for ((valor, clave) in diccionarioGuatemala) {
                if (clave == infopais) {
                    val resultado =
                        "El usuario quiso observar cuanto(a) $clave posee $paisSeleccionado, este posee $valor."
                    val intent = Intent()
                    intent.putExtra("resultado", resultado)
                    setResult(Activity.RESULT_OK, intent)
                    //Toast.makeText(this@MainActivity2, "pais: $resultado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
    fun spinnerExample(){
        val elementos = resources.getStringArray(R.array.infopaises)

        val spinner: Spinner = findViewById(R.id.spinner)

        // Crea un ArrayAdapter usando los elementos y el diseño predeterminado para el spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, elementos)

        // Especifica el diseño que se usará cuando se desplieguen las opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Une el ArrayAdapter al Spinner
        spinner.adapter = adapter

        // Opcionalmente, puedes configurar un escuchador para detectar la selección del usuario

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSeleccionado = elementos[position]
                // Realiza alguna acción con el elemento seleccionado
                Toast.makeText(this@MainActivity2, "Presiona el botón mostar, para ver la información seleccionada", Toast.LENGTH_SHORT).show()
                infopais = itemSeleccionado
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Se llama cuando no se ha seleccionado nada en el Spinner (opcional)
                Toast.makeText(this@MainActivity2, "Nada", Toast.LENGTH_SHORT).show()
            }
        }
    }


}