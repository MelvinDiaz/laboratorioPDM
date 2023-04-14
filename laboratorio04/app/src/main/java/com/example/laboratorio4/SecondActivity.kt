package com.example.laboratorio4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var txtName: TextView
    private lateinit var txtEmail: TextView
    private lateinit var txtPhone: TextView
    private lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bind()
        values()
    }

    fun bind() {
        txtName = findViewById(R.id.name_text_view)
        txtEmail = findViewById(R.id.email_text_view)
        txtPhone = findViewById(R.id.phone_text_view)
        buttonShare = findViewById(R.id.action_share)
    }

    fun values() {
        val userName = intent.getStringExtra("name")
        val userEmail = intent.getStringExtra("email")
        val userPhone = intent.getStringExtra("phone")

        txtName.text = getString(R.string.hint_nombre, userName)
        txtEmail.text = getString(R.string.hint_txt_email, userEmail)
        txtPhone.text = getString(R.string.hint_txt_phone, userPhone)

        buttonShare.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nombre: $userName\nEmail: $userEmail\nTeléfono: $userPhone")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }
}