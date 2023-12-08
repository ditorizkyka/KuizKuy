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
        topic1.text = "Geografi"
        topic1.setOnClickListener {
            val img = R.drawable.undraw_adventure_re_ncqp
            val question = resources.getStringArray(R.array.question1)
            val answer1 = resources.getStringArray(R.array.question1_answer1)
            val answer2 = resources.getStringArray(R.array.question1_answer2)
            val answer3 = resources.getStringArray(R.array.question1_answer3)
            val trueAnswer = resources.getStringArray(R.array.question1_true_answer)
            val q = Question(img, question, answer1, answer2, answer3, trueAnswer, 0, 0)
            startActivity(
                Intent(this@MainActivity, QuizActivity::class.java).putExtra(
                    QuizActivity.EXTRA_QUESTION,
                    q
                )
            )
        }

        val topic2: Button = findViewById(R.id.btn_topic2)
        topic2.text = "Sejarah"
        topic2.setOnClickListener {
            val img = R.drawable.undraw_books_re_8gea
            val question = resources.getStringArray(R.array.question2)
            val answer1 = resources.getStringArray(R.array.question2_answer1)
            val answer2 = resources.getStringArray(R.array.question2_answer2)
            val answer3 = resources.getStringArray(R.array.question2_answer3)
            val trueAnswer = resources.getStringArray(R.array.question2_true_answer)
            val q = Question(img, question, answer1, answer2, answer3, trueAnswer, 0, 0)
            startActivity(
                Intent(this@MainActivity, QuizActivity::class.java).putExtra(
                    QuizActivity.EXTRA_QUESTION,
                    q
                )
            )
        }
    }
}