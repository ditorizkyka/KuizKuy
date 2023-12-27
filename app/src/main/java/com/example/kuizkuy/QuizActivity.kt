package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback

class QuizActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_q"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        onBackPressedDispatcher.addCallback(this) {

        }

        val backBtn: Button = findViewById(R.id.btn_back)

        backBtn.setOnClickListener {
            startActivity(Intent(this@QuizActivity, MainActivity::class.java))
            finish()
        }

        val qNumber: TextView = findViewById(R.id.question_number)
        val img: ImageView = findViewById(R.id.question_image)
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
            qNumber.text = buildString {
                append(q.indicator + 1)
                append(".")
            }
            img.setImageResource(q.img)
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
                    finish()
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                    finish()
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
                    finish()
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                    finish()
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
                    finish()
                } else {
                    startActivity(
                        Intent(this@QuizActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTION,
                            q
                        )
                    )
                    finish()
                }
            }
        }
    }
}