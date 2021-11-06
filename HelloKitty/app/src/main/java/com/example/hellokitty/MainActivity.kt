package com.example.hellokitty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mHelloTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mHelloTextView = findViewById(R.id.textView)

        var imageButton: ImageButton = findViewById(R.id.imageButton)

        imageButton.setOnClickListener {
            mHelloTextView.setText("Hello Kitty")
        }
    }
}