package com.akj.lotto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class ConstellationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)
        Toast.makeText(applicationContext, "ConstellationActivity 입니다.", Toast.LENGTH_LONG).show()
    }
}
