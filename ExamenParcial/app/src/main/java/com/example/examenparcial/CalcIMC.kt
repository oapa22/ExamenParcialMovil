package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalcIMC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calc_imc)
        navegar1()
        calcularIMC()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navegar1(){
        val btn1 = findViewById<Button>(R.id.regresar)
        btn1.setOnClickListener(){
            val saltarVentana = Intent(this,Home::class.java)
            startActivity(saltarVentana)
        }
    }

    fun calcularIMC() {
        val btnCalcular = findViewById<Button>(R.id.calcular)
        val inputPeso = findViewById<TextView>(R.id.inputpeso)
        val inputAltura = findViewById<TextView>(R.id.inputaltura)
        val textoResultado = findViewById<TextView>(R.id.textoresultado)
        val numeroIMC = findViewById<TextView>(R.id.numeroimc)

        btnCalcular.setOnClickListener {
            val pesoT = inputPeso.text.toString()
            val alturaT = inputAltura.text.toString()

            if (pesoT.isNotBlank() && alturaT.isNotBlank()) {
                val peso = pesoT.toFloatOrNull()
                val altura = alturaT.toFloatOrNull()

                if (peso != null && altura != null && altura > 0) {
                    val imc = peso / (altura * altura)

                    val imcFormateado = String.format("%.2f", imc)
                    numeroIMC.text = imcFormateado

                    textoResultado.text = when {
                        imc < 18.5 -> "Bajo peso"
                        imc < 24.9 -> "Peso normal"
                        imc < 29.9 -> "Sobrepeso"
                        else -> "Obesidad"
                    }
                }
            } else {
                Toast.makeText(this, "Llena ambos campos.", Toast.LENGTH_SHORT).show()
            }
        }

    }


}