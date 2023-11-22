package com.example.layoutsaa

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AluguelCarro:AppCompatActivity() {
    lateinit var tvSelectedDate: TextView
    lateinit var btnDataSelector: Button
    private val calendar = Calendar.getInstance()
    lateinit var tvDevolucao: TextView
    lateinit var btndevolucao: Button
    lateinit var btnConclusao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aluguel)
        setupView()



        btnDataSelector.setOnClickListener(){
            showDataPicker()
        }

        btndevolucao.setOnClickListener(){

                showDataTwo()


        }
        btnConclusao.setOnClickListener(){
            startActivity(Intent(this,UltimaTela::class.java))
        }

    }


    private fun setupView(){
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnDataSelector = findViewById(R.id.btnDataSelector)
        tvDevolucao = findViewById(R.id.tvDevolucao)
        btndevolucao = findViewById(R.id.btndevolucao)
        btnConclusao = findViewById(R.id.conclusão)
    }

    private fun showDataPicker(){
        val datePickerDialog = DatePickerDialog(
            this,{DatePicker, year:Int, monthOfYear:Int, dayOfMonth:Int ->
                val selectedDate: Calendar = Calendar.getInstance()
                selectedDate.set(year,monthOfYear,dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate: String = dateFormat.format(selectedDate.time)
                tvSelectedDate.text= "Data selecionada: "+ formattedDate
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showDataTwo(){
        val datePickerDialog = DatePickerDialog(
            this, { _, year, monthOfYear, dayOfMonth ->
                val selectedDate: Calendar = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)

                // Verifica se a data selecionada é maior que a data do showDataPicker()
                if (selectedDate.timeInMillis <= calendar.timeInMillis) {
                    // Mostra mensagem de erro
                    Toast.makeText(
                        this@AluguelCarro,
                        "Data de devolução invalida.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val formattedDate: String = dateFormat.format(selectedDate.time)
                    tvDevolucao.text = "Data de devolução: " + formattedDate
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }


}