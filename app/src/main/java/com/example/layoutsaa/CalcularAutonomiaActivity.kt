package com.example.layoutsaa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CalcularAutonomiaActivity: AppCompatActivity(){
    lateinit var preco: EditText
    lateinit var percorrido: EditText
    lateinit var resultado: TextView
    lateinit var btncalcular: Button
    lateinit var btnclose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcularautonomia)
        setupView()
        setupListerner()

    }
    fun setupView(){
        preco = findViewById(R.id.et_preço_kwh)
        percorrido = findViewById(R.id.et_percorrido)
        resultado = findViewById(R.id.tv_resultado)
        btncalcular = findViewById(R.id.btn_calcular)
        btnclose = findViewById(R.id.iv_close)

    }
    fun setupListerner() {
        btncalcular.setOnClickListener {
            val kM = percorrido.text.toString().toFloat()
            val precoKw = preco.text.toString().toFloat()
            val res = kM / precoKw
            resultado.text = res.toString()

        }
        btnclose.setOnClickListener{
            finish()
        }
    }
}