package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var personHeight: EditText
    private lateinit var personWeight: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var totalBmi: TextView
    private lateinit var personHealth: TextView
    private lateinit var healthRange: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()


        bind()
        eventListeners()
    }

    private fun bind() {
        personHeight = findViewById(R.id.edit_text_height)
        personWeight = findViewById(R.id.edit_text_weight)
        buttonCalculate = findViewById(R.id.button_calculate)
        totalBmi = findViewById(R.id.text_view_totalbmi)
        personHealth = findViewById(R.id.text_view_person_health)
        healthRange = findViewById(R.id.text_view_range)

    }

    private fun eventListeners(){
        buttonCalculate.setOnClickListener(){
            calculateBmi()
        }
    }

    private fun calculateBmi(){

        if(personHeight.text.isEmpty() || personWeight.text.isEmpty()){

            personHealth.text = "Tienes que ingresar datos"
            healthRange.text = "Error"

        } else {
        val height = personHeight.text.toString().toDouble() / 100
        val weight = personWeight.text.toString().toDouble()
        var bmi = (weight / (height * height))
        bmi = bmi.roundToInt().toDouble()
        totalBmi.text = bmi.toString()


            if (bmi < 18.5) {
                personHealth.text = "Underweight"
                healthRange.text = "18.5 - 24.9"
                personHealth.setTextColor(getColor(R.color.under_weight))
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                personHealth.text = "Normal"
                healthRange.text = "18.5 - 24.9"
                personHealth.setTextColor(getColor(R.color.normal_weight))
            } else if (bmi >= 25 && bmi <= 29.9) {
                personHealth.text = "Overweight"
                personHealth.setTextColor(getColor(R.color.over_weight))
                healthRange.text = "25 - 29.9"
            } else if (bmi >= 30) {
                personHealth.setTextColor(getColor(R.color.obese))
                personHealth.text = "Obese"
                healthRange.text = "30 or more"
            }
        }
    }
}