package com.example.kuizkuy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topic1: Button = findViewById(R.id.btn_topic1)
        topic1.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }

        val topic2: Button = findViewById(R.id.btn_topic2)
        topic2.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }

        val topic3: Button = findViewById(R.id.btn_topic3)
        topic3.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }

        val topic4: Button = findViewById(R.id.btn_topic4)
        topic4.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }

        val topic5: Button = findViewById(R.id.btn_topic5)
        topic5.setOnClickListener {
            startActivity(Intent(this@MainActivity, QuizActivity::class.java))
        }
    }
}