package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class QuizEssayActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTIONESSAY = "extra_q"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_essay)

        val img: ImageView = findViewById(R.id.question_image)
        val qNumber: TextView = findViewById(R.id.question_number)
        val question: TextView = findViewById(R.id.question)
        val input : EditText = findViewById(R.id.input_answer)
        val next : Button = findViewById(R.id.next_btn)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(QuizEssayActivity.EXTRA_QUESTIONESSAY, QuestionEssay::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(QuizEssayActivity.EXTRA_QUESTIONESSAY)
        }

        if (q != null) {
            img.setImageResource(q.img)
            qNumber.text = "No. ${q.indicator + 1}"
            question.text = q.question[q.indicator]

            next.setOnClickListener {
                val inputPolusi = input.text.toString()
                if (inputPolusi == q.trueAnswer[q.indicator]) {
                    q.point++
                }
                q.indicator++
                if (q.indicator < q.question.size) {
                    startActivity(
                        Intent(this@QuizEssayActivity, QuizEssayActivity::class.java).putExtra(
                            QuizEssayActivity.EXTRA_QUESTIONESSAY,
                            q
                        )
                    )
                } else {
                    startActivity(
                        Intent(this@QuizEssayActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTIONESSAY,
                            q
                        )
                    )
                }
            }
        }
    }
}