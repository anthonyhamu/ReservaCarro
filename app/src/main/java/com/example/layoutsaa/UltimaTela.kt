package com.example.layoutsaa

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UltimaTela:AppCompatActivity() {
    lateinit var btnReserva: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conclusao)

        setupView()

        btnReserva.setOnClickListener(){
            Toast.makeText(
                this@UltimaTela,
                "Sua reserva foi concluida com sucesso, apresente o ID na concesonária.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun setupView(){
        btnReserva = findViewById(R.id.reserva)
    }
}