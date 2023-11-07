package com.example.layoutsaa

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AluguelCarro:AppCompatActivity() {
    lateinit var tvSelectedDate: TextView
    lateinit var btnDataSelector: Button
    private val calendar = Calendar.getInstance()
    lateinit var tvDevolucao: TextView
    lateinit var btndevolucao: Button

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

    }
    private fun setupView(){
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        btnDataSelector = findViewById(R.id.btnDataSelector)
        tvDevolucao = findViewById(R.id.tvDevolucao)
        btndevolucao = findViewById(R.id.btndevolucao)
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
        val datePickerDialog = DatePickerDialog(this, {DatePicker, year:Int, monthOfYear:Int, dayOfMonth:Int ->
            val selectedDate: Calendar = Calendar.getInstance()
            selectedDate.set(year, monthOfYear, dayOfMonth)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val formattedDate: String = dateFormat.format(selectedDate.time)
            tvDevolucao.text = "Data de devolução: "+ formattedDate
        },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    datePickerDialog.show()
    }


}