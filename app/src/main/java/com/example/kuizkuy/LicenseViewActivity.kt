package com.example.kuizkuy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class LicenseViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license_view)

        onBackPressedDispatcher.addCallback(this) {
            startActivity(Intent(this@LicenseViewActivity, AboutApp::class.java))
            finish()
        }

        val btn: Button = findViewById(R.id.btn_back_license)

        btn.setOnClickListener {
            startActivity(Intent(this@LicenseViewActivity, AboutApp::class.java))
            finish()
        }

        val license: TextView = findViewById(R.id.license_view)

        var text = ""
        var reader: BufferedReader? = null

        try {
            reader = BufferedReader(InputStreamReader(assets.open("license-notice.txt")))
            text = reader.readLines().joinToString("\n")
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                reader?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            license.text = text
        }
    }
}