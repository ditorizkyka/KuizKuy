package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_question"
        const val EXTRA_QUESTIONESSAY = "extra_q_essay"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val score: TextView = findViewById(R.id.score)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTION, Question::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTION)
        }
        if (q != null ) {
            score.text = "${(q.point*100)/q.question.size}/100"
        }

        val e = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY, QuestionEssay::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY)
        }


        if (e != null) {
            score.text = "${(e.point*100)/e.question.size}/100"
        }

        val finishBtn: Button = findViewById(R.id.btn_finish)

        finishBtn.setOnClickListener {
            startActivity(Intent(this@FinishActivity, MainActivity::class.java))
        }
    }
}