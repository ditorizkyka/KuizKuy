package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class QuizActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_q"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val img: ImageView = findViewById(R.id.question_image)
        val qNumber: TextView = findViewById(R.id.question_number)
        val question: TextView = findViewById(R.id.question)
        val answer1: Button = findViewById(R.id.answer1)
        val answer2: Button = findViewById(R.id.answer2)
        val answer3: Button = findViewById(R.id.answer3)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTION, Question::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTION)
        }

        if (q != null) {
            img.setImageResource(q.img)
            qNumber.text = "No. ${q.indicator + 1}"
            question.text = q.question[q.indicator]
            answer1.text = q.answer1[q.indicator]
            answer2.text = q.answer2[q.indicator]
            answer3.text = q.answer3[q.indicator]

            answer1.setOnClickListener {
                if (answer1.text == q.trueAnswer[q.indicator]) {
                    q.point++
                }
                q.indicator++
                if (q.indicator < q.question.size) {
                    startActivity(
                        Intent(this@QuizActivity, QuizActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            q
                        )
                    )
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                }
            }

            answer2.setOnClickListener {
                if (answer2.text == q.trueAnswer[q.indicator]) {
                    q.point++
                }
                q.indicator++
                if (q.indicator < q.question.size) {
                    startActivity(
                        Intent(this@QuizActivity, QuizActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            q
                        )
                    )
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                }
            }

            answer3.setOnClickListener {
                if (answer3.text == q.trueAnswer[q.indicator]) {
                    q.point++
                }
                q.indicator++
                if (q.indicator < q.question.size) {
                    startActivity(
                        Intent(this@QuizActivity, QuizActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            q
                        )
                    )
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                }
            }
        }
    }
}