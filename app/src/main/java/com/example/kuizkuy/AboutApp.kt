package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback

class AboutApp : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        onBackPressedDispatcher.addCallback(this) {
            startActivity(Intent(this@AboutApp, MainActivity::class.java))
            finish()
        }

        val backBtn = findViewById<Button>(R.id.btn_back)
        backBtn.setOnClickListener {
            startActivity(Intent(this@AboutApp,MainActivity::class.java))
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

        val license: TextView = findViewById(R.id.license)

        license.setOnClickListener {
            startActivity(Intent(this@AboutApp, LicenseViewActivity::class.java))
            finish()
        }
    }

}