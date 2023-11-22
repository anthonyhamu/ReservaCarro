package com.example.layoutsaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button



import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    private lateinit var btnentrar: Button
    private lateinit var btncarro: CardView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListerners()
        setupList()
    }
    private fun setupView(){
         btnentrar= findViewById(R.id.btn_entrar)


        btncarro= findViewById(R.id.cv_view)

    }
    private fun setupList(){
        btncarro.setOnClickListener{
            startActivity( Intent(this,AluguelCarro::class.java))
        }

    }
    private fun setupListerners(){

        btnentrar.setOnClickListener{

            startActivity( Intent(this,CalcularAutonomiaActivity::class.java))

        }
    }

}