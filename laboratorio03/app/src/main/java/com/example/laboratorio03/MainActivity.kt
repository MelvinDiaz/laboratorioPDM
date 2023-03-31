package com.example.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var dollar: ImageView
    private lateinit var totalView: TextView
    private var total = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bind()
        eventListeners()

    }

    private fun bind() {
        fiveCents = findViewById<ImageView>(R.id.image_five)
        tenCents = findViewById<ImageView>(R.id.image_ten)
        quarter = findViewById<ImageView>(R.id.image_quarter)
        dollar = findViewById<ImageView>(R.id.image_dollar)
        totalView = findViewById(R.id.text_view_cantidad_dinero)
    }

    private fun eventListeners() {

        fiveCents.setOnClickListener() {
            total += 0.05
            total = String.format("%.2f", total).toDouble()
            totalView.text = total.toString()
        }
        tenCents.setOnClickListener() {
            total += 0.10
            total = String.format("%.2f", total).toDouble()
            totalView.text = total.toString()
        }
        quarter.setOnClickListener() {
            total += 0.25
            total = String.format("%.2f", total).toDouble()
            totalView.text = total.toString()
        }
        dollar.setOnClickListener() {
            total += 1.00
            total = String.format("%.2f", total).toDouble()
            totalView.text = total.toString()
        }


    }

}