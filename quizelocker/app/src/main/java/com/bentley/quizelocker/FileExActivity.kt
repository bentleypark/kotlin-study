package com.bentley.quizelocker

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.FileNotFoundException

class FileExActivity : AppCompatActivity(R.layout.activity_file_ex) {

    val filename = "data.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        saveButton.setOnClickListener {

            val text = textField.toString()
            when {

                TextUtils.isEmpty(text) -> {
                    Toast.makeText(applicationContext, "텍스트가 비어있습니다.", Toast.LENGTH_LONG).show()
                }
                else -> {
                    saveToInnerStorage(text, filename)
                }
            }
        }

        loadButton.setOnClickListener {

            try {

                textField.setText(loadFromInnerStorage(filename))

            } catch (e: FileNotFoundException) {
                Toast.makeText(applicationContext, "저장된 텍스트가 없습니.", Toast.LENGTH_LONG).show()
            }
        }


    }

    private fun loadFromInnerStorage(filename: String): String {

        val fileInputStream = openFileInput(filename)

        return fileInputStream.reader().readText()
    }

    private fun saveToInnerStorage(text: String, filename: String) {

        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)

        fileOutputStream.write(text.toByteArray())

        fileOutputStream.close()
    }
}