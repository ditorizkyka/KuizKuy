package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.addCallback

class AboutAppActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        onBackPressedDispatcher.addCallback(this) {
            startActivity(Intent(this@AboutAppActivity, MainActivity::class.java))
            finish()
        }

        val backBtn = findViewById<Button>(R.id.btn_back)
        backBtn.setOnClickListener {
            startActivity(Intent(this@AboutAppActivity,MainActivity::class.java))
            finish()
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