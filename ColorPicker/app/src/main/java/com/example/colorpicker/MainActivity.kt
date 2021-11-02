package com.example.colorpicker

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()


        val btnSeleccionar = findViewById<Button>(R.id.btnSeleccionar)


        btnSeleccionar.setOnClickListener {

            saveData()
        }


    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedRed = sharedPreferences.getInt("bgRed", 255)
        val savedGreen = sharedPreferences.getInt("bgGreen", 255)
        val savedBlue = sharedPreferences.getInt("bgBlue", 255)
        val bgElement = findViewById<View>(R.id.layout) as ConstraintLayout
        bgElement.setBackgroundColor(Color.argb(255, savedRed, savedGreen, savedBlue))
        val valorRojo = findViewById<SeekBar>(R.id.sliderRojo)
        val valorAzul = findViewById<SeekBar>(R.id.sliderAzul)
        val valorVerde = findViewById<SeekBar>(R.id.sliderVerde)
        val strColor = findViewById<TextView>(R.id.editColor)
        valorRojo.progress = savedRed
        valorVerde.progress = savedGreen
        valorAzul.progress = savedBlue
        strColor.text = "Color: ($savedRed, $savedGreen, $savedBlue)"
    }

    private fun saveData() {
        val valorRojo = findViewById<SeekBar>(R.id.sliderRojo)
        val valorAzul = findViewById<SeekBar>(R.id.sliderAzul)
        val valorVerde = findViewById<SeekBar>(R.id.sliderVerde)
        val strColor = findViewById<TextView>(R.id.editColor)
        val bgElement = findViewById<View>(R.id.layout) as ConstraintLayout
        val rojo = valorRojo.progress
        val verde = valorVerde.progress
        val azul = valorAzul.progress
        bgElement.setBackgroundColor(Color.argb(255, rojo, verde, azul))
        strColor.text = "Color: ($rojo, $verde, $azul)"


        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putInt("bgRed", rojo)
            putInt("bgGreen", verde)
            putInt("bgBlue", azul)
        }.apply()

        Toast.makeText(this, "Se ha guardado la selección", Toast.LENGTH_SHORT).show()
    }

}
