package com.example.kuizkuy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val finishBtn: Button = findViewById(R.id.btn_finish)

        finishBtn.setOnClickListener {
            startActivity(Intent(this@FinishActivity, MainActivity::class.java))
        }
    }
}