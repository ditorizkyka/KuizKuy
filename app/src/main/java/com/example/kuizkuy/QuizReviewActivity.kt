package com.example.kuizkuy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback

class QuizReviewActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTION = "extra_question"
        const val EXTRA_QUESTIONESSAY = "extra_q_essay"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_review)

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

        onBackPressedDispatcher.addCallback(this) {
            if (q?.indicator == 0 || e?.indicator == 0) {
                startActivity(Intent(this@QuizReviewActivity, MainActivity::class.java))
                finish()
            } else {
                if (q != null) {
                    q.indicator--
                    startActivity(
                        Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            q
                        )
                    )
                    finish()
                } else if (e != null) {
                    e.indicator--
                    startActivity(
                        Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            e
                        )
                    )
                    finish()
                }
            }
        }

        val backBtn: Button = findViewById(R.id.btn_back)

        backBtn.setOnClickListener {
            startActivity(Intent(this@QuizReviewActivity, MainActivity::class.java))
            finish()
        }

        val qNumber: TextView = findViewById(R.id.question_number)
        val img: ImageView = findViewById(R.id.question_image)
        val question: TextView = findViewById(R.id.question)
        val answer: TextView = findViewById(R.id.answer_content)

        val prevBtn: Button = findViewById(R.id.btn_prev)
        val nextBtn: Button = findViewById(R.id.btn_next)

        if (q != null) {
            qNumber.text = buildString {
                append("No. ")
                append(q.indicator + 1)
            }
            img.setImageResource(q.img)
            question.text = q.question[q.indicator]
            answer.text = q.trueAnswer[q.indicator]

            if (q.indicator == 0) {
                prevBtn.visibility = View.INVISIBLE
            } else if (q.indicator == q.question.size - 1) {
                nextBtn.text = "Selesai"
            }
        } else if (e != null) {
            qNumber.text = buildString {
                append("No. ")
                append(e.indicator + 1)
            }
            img.setImageResource(e.img)
            question.text = e.question[e.indicator]
            answer.text = e.trueAnswer[e.indicator]

            if (e.indicator == 0) {
                prevBtn.visibility = View.INVISIBLE
            } else if (e.indicator == e.question.size - 1) {
                nextBtn.text = "Selesai"
            }
        }

        prevBtn.setOnClickListener {
            if (q != null) {
                q.indicator--
                startActivity(
                    Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                        EXTRA_QUESTION,
                        q
                    )
                )
                finish()
            } else if (e != null) {
                e.indicator--
                startActivity(
                    Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                        EXTRA_QUESTIONESSAY,
                        e
                    )
                )
                finish()
            }
        }

        nextBtn.setOnClickListener {
            if (q != null) {
                if (q.indicator < q.question.size - 1) {
                    q.indicator++
                    startActivity(
                        Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                            EXTRA_QUESTION,
                            q
                        )
                    )
                    finish()
                } else {
                    startActivity(Intent(this@QuizReviewActivity, MainActivity::class.java))
                    finish()
                }
            } else if (e != null) {
                if (e.indicator < e.question.size - 1) {
                    e.indicator++
                    startActivity(
                        Intent(this@QuizReviewActivity, QuizReviewActivity::class.java).putExtra(
                            EXTRA_QUESTIONESSAY,
                            e
                        )
                    )
                    finish()
                } else {
                    startActivity(Intent(this@QuizReviewActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }
}