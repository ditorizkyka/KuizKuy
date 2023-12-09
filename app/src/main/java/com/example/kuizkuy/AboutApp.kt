package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutApp : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        val backAbout = findViewById<Button>(R.id.btn_back_about)
        backAbout.setOnClickListener {
            startActivity(Intent(this@AboutApp,MainActivity::class.java))
        }

        val dito: Button = findViewById(R.id.dito)

        dito.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/anditorizkyka")))
        }

        val maruf: Button = findViewById(R.id.maruf)

        maruf.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/maruffirdaus")))
        }
    }

}