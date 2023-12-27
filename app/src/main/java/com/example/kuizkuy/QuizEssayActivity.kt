package com.example.kuizkuy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.addCallback

class QuizEssayActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_QUESTIONESSAY = "extra_q"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_essay)

        onBackPressedDispatcher.addCallback(this) {

        }

        val backBtn: Button = findViewById(R.id.btn_back)

        backBtn.setOnClickListener {
            startActivity(Intent(this@QuizEssayActivity, MainActivity::class.java))
            finish()
        }

        val qNumber: TextView = findViewById(R.id.question_number)
        val img: ImageView = findViewById(R.id.question_image)
        val question: TextView = findViewById(R.id.question)
        val input: EditText = findViewById(R.id.input_answer)
        val nextBtn: Button = findViewById(R.id.btn_next)

        val q = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY, QuestionEssay::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_QUESTIONESSAY)
        }

        if (q != null) {
            qNumber.text = buildString {
                append(q.indicator + 1)
                append(".")
            }
            img.setImageResource(q.img)
            question.text = q.question[q.indicator]

            input.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    nextBtn.performClick()
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }

            nextBtn.setOnClickListener {
                val inputAnswer = input.text.toString()
                if (inputAnswer == q.trueAnswer[q.indicator]) {
                    q.point++
                }
                q.indicator++
                if (q.indicator < q.question.size) {
                    startActivity(
                        Intent(this@QuizEssayActivity, QuizEssayActivity::class.java).putExtra(
                            EXTRA_QUESTIONESSAY,
                            q
                        )
                    )
                    finish()
                } else {
                    startActivity(
                        Intent(this@QuizEssayActivity, FinishActivity::class.java).putExtra(
                            FinishActivity.EXTRA_QUESTIONESSAY,
                            q
                        )
                    )
                    finish()
                }
            }
        }
    }
}