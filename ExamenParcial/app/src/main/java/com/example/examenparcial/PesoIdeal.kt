package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PesoIdeal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_peso_ideal)
        navegar1()
        calcularPesoIdeal()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcularPesoIdeal() {
        val btnCalcular = findViewById<Button>(R.id.calcular2)
        val inputAltura = findViewById<TextView>(R.id.inputaltura2)
        val textoPesoIdeal = findViewById<TextView>(R.id.textoresultado2)
        val numeroPesoIdeal = findViewById<TextView>(R.id.numeropeso)

        val radioHombre = findViewById<RadioButton>(R.id.radioHombre)
        val radioMujer = findViewById<RadioButton>(R.id.radioMujer)

        btnCalcular.setOnClickListener {
            val alturaT = inputAltura.text.toString()

            if (alturaT.isNotBlank() && alturaT.isNotBlank()) {
                val altura = alturaT.toFloatOrNull()

                if (altura != null && altura > 0) {
                    val pesoIdeal = if (radioHombre.isChecked) {
                        altura - 100
                    } else if (radioMujer.isChecked) {
                        altura - 105
                    } else {
                        null
                    }

                    if (pesoIdeal != null) {
                        numeroPesoIdeal.text = String.format("%.2f", pesoIdeal)
                        textoPesoIdeal.text = String.format("%.2f", pesoIdeal)
                    } else {
                        Toast.makeText(this, "Selecciona tu género.", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Llena ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun navegar1(){
        val btn1 = findViewById<Button>(R.id.regresar2)
        btn1.setOnClickListener(){
            val saltarVentana = Intent(this,Home::class.java)
            startActivity(saltarVentana)
        }
    }
}