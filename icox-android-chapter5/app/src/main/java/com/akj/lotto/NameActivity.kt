package com.akj.lotto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_constellation.*
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        goButton.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
