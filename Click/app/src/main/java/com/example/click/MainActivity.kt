package com.example.click

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var counter: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            textView.text = "Hello my friend!"
        }

        val button2: Button = findViewById(R.id.button2)
        println("!!!")
        println(button2)
        button2.setOnClickListener {
            textView.text = "Я насчитал ${++counter} ворон"
        }
    }
}
