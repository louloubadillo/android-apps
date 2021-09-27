package com.example.quadraticformula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editA = findViewById<EditText>(R.id.editA)
        val editB = findViewById<EditText>(R.id.editB)
        val editC = findViewById<EditText>(R.id.editC)
        val btnResolver = findViewById<Button>(R.id.btnResolver)

        val raiz1 = findViewById<TextView>(R.id.raiz1)
        val raiz2 = findViewById<TextView>(R.id.raiz2)

        btnResolver.setOnClickListener{
            val a = editA.text.toString()
            val b = editB.text.toString()
            val c = editC.text.toString()
            val r1: Double
            val r2: Double

            if(a == "" || b=="" || c==""){
                Toast.makeText(this, "Ingresa los valores a, b y c", Toast.LENGTH_SHORT).show()
            }

            else{
                if(a == "0"){
                    Toast.makeText(this, "El valor de a no puede ser 0", Toast.LENGTH_SHORT).show()
                }
                else{
                    val determinant = b.toDouble() * b.toDouble() - 4.0 * a.toDouble() * c.toDouble()
                    if(determinant >= 0){
                        r1 = (-b.toDouble() + sqrt(determinant)) / (2 * a.toDouble())
                        r2 = (-b.toDouble() - sqrt(determinant)) / (2 * a.toDouble())
                        val r1f = String.format("%.3f",r1)
                        val r2f = String.format("%.3f",r2)
                        val res1 = "Raíz 1: $r1f"
                        val res2 = "Raíz 2: $r2f"
                        raiz1.text = res1
                        raiz2.text = res2

                    }
                    else{
                        val real = -b.toDouble() / (2 * a.toDouble())
                        val imaginary = sqrt(-determinant) / (2 * a.toDouble())
                        val r = String.format("%.3f",real)
                        val i = String.format("%.3f",imaginary)
                        val res1 = "Raiz 1: $r + $i i"
                        val res2 = "Raiz 2: $r - $i i"
                        raiz1.text = res1
                        raiz2.text = res2
                    }
                }
            }


        }

    }
}