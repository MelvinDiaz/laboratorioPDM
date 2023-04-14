package com.example.laboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPhone: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        sendData()
    }

    private fun bind(){
        userName = findViewById<EditText>(R.id.name_edit_text)
        userEmail = findViewById<EditText>(R.id.email_edit_text)
        userPhone = findViewById<EditText>(R.id.phone_edit_text)
        saveButton = findViewById(R.id.save_button)
    }

    fun sendData(){
        saveButton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("name", userName.text.toString())
                putExtra("email", userEmail.text.toString())
                putExtra("phone", userPhone.text.toString())
            }
            startActivity(intent)
        }
    }
}