package com.example.examenparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ExamenParcial)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        navegar1()
        navegar2()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun navegar1(){
        val btn1 = findViewById<Button>(R.id.masacorp)
        btn1.setOnClickListener(){
            val saltarVentana = Intent(this,CalcIMC::class.java)
            startActivity(saltarVentana)
        }
    }
    fun navegar2(){
        val btn1 = findViewById<Button>(R.id.pesoideal)
        btn1.setOnClickListener(){
            val saltarVentana = Intent(this,PesoIdeal::class.java)
            startActivity(saltarVentana)
        }
    }
}