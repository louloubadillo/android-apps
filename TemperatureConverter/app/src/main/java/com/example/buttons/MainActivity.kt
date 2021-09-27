package com.example.buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCelsius = findViewById<EditText>(R.id.editCelsius)
        val editFahrenheit = findViewById<EditText>(R.id.editFahrenheit)
        val btnConvertir = findViewById<Button>(R.id.buttonConv)

        btnConvertir.setOnClickListener{
            val celsius = editCelsius.text.toString()
            val fahrenheit = editFahrenheit.text.toString()

            if (celsius == "" && fahrenheit == ""){
                Toast.makeText(this, "Ingresa una temperatura", Toast.LENGTH_SHORT).show()

            }
            else if (celsius =="" && fahrenheit != ""){
                val converted = (fahrenheit.toDouble()-32)*(5/9f)
                editCelsius.setText(String.format("%.3f", converted))
                btnConvertir.setText("Reiniciar")
            }
            else if(celsius != "" && fahrenheit == ""){
                val converted = celsius.toDouble() * (9/5f) + 32
                editFahrenheit.setText(String.format("%.3f", converted))
                btnConvertir.setText("Reiniciar")

            }
            else {
                editCelsius.setText("")
                editFahrenheit.setText("")
                btnConvertir.setText("Convertir")
            }
        }

    }
}

