package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AboutApp : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        val backAbout = findViewById<Button>(R.id.btn_backAbout)
        backAbout.setOnClickListener {
            startActivity(Intent(this@AboutApp,MainActivity::class.java))
        }

    }

}