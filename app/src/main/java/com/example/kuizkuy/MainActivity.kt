package com.example.kuizkuy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topic1: Button = findViewById(R.id.btn_topic1)
        topic1.text = getString(R.string.geography)
        topic1.setOnClickListener {
            val img = R.drawable.undraw_lost_re_xqjt
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
        topic2.text = getString(R.string.history)
        topic2.setOnClickListener {
            val img = R.drawable.undraw_be_the_hero_ssr2
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

        val topic3: Button = findViewById(R.id.btn_topic3)
        topic3.text = getString(R.string.mathematics)
        topic3.setOnClickListener {
            val img = R.drawable.undraw_quiz_re_aol4
            val question = resources.getStringArray(R.array.question3)
            val trueAnswer = resources.getStringArray(R.array.question3_true_answer)
            val q = QuestionEssay(img, question, trueAnswer, 0, 0)
            startActivity(
                Intent(this@MainActivity, QuizEssayActivity::class.java).putExtra(
                    QuizEssayActivity.EXTRA_QUESTIONESSAY,
                    q
                )
            )
        }

        val btnAbout = findViewById<Button>(R.id.btn_about)
        btnAbout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_about -> {
                val moveAbout = Intent(this@MainActivity, AboutAppActivity::class.java)
                startActivity(moveAbout)
            }
        }
    }
}