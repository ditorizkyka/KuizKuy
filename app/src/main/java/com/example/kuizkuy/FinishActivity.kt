package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback

class FinishActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_question"
        const val EXTRA_QUESTIONESSAY = "extra_q_essay"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        onBackPressedDispatcher.addCallback(this) {

        }

        val score: TextView = findViewById(R.id.score)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTION, Question::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTION)
        }

        val e = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY, QuestionEssay::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY)
        }

        if (q != null) {
            score.text = buildString {
                append((q.point * 100) / q.question.size)
                append("/100")
            }
        } else if (e != null) {
            score.text = buildString {
                append((e.point * 100) / e.question.size)
                append("/100")
            }
        }

        val reviewBtn: Button = findViewById(R.id.btn_review)

        reviewBtn.setOnClickListener {
            if (q != null) {
                q.indicator = 0
                startActivity(
                    Intent(this@FinishActivity, QuizReviewActivity::class.java).putExtra(
                        QuizReviewActivity.EXTRA_QUESTION,
                        q
                    )
                )
                finish()
            } else if (e != null) {
                e.indicator = 0
                startActivity(
                    Intent(this@FinishActivity, QuizReviewActivity::class.java).putExtra(
                        QuizReviewActivity.EXTRA_QUESTIONESSAY,
                        e
                    )
                )
                finish()
            }
        }

        val finishBtn: Button = findViewById(R.id.btn_finish)

        finishBtn.setOnClickListener {
            startActivity(Intent(this@FinishActivity, MainActivity::class.java))
            finish()
        }
    }
}