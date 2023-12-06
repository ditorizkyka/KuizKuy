package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail)

        val restartBtn: Button = findViewById(R.id.btn_finish)
        val homeBtn: Button = findViewById(R.id.btn_home_fail)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTION, Question::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTION)
        }

        if (q != null) {
            restartBtn.setOnClickListener {
                startActivity(Intent(this@FailActivity, QuizActivity::class.java).putExtra(
                    QuizActivity.EXTRA_QUESTION,
                    q
                ))
            }
        }

        homeBtn.setOnClickListener {
            startActivity(Intent(this@FailActivity, MainActivity::class.java))
        }
    }
}