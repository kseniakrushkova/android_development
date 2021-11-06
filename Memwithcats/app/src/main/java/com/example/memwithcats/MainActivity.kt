package com.example.memwithcats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondText: TextView = findViewById(R.id.second_text)
        val thirdText: TextView = findViewById(R.id.third_text)
        val forthText: TextView = findViewById(R.id.forth_text)
        val rightBottomImage: ImageView = findViewById(R.id.right_bottom_image)

        // Обработчик щелчков
        rightBottomImage.setOnClickListener {
            val phrases = listOf(
                "Уже 6 часов утра, Наташ",
                "Вставай, мы там всё уронили",
                "Мы уронили вообще всё, Наташ, честно",
                "Наташ, ты чё опять лежишь?",
                "Часики-то тикают",
                "Мужика-то хоть нашла себе?",
                "Уже дитачек пора рожать вообще-то")

            val shuffledList = phrases.shuffled() // перемешанный список

            // Выводим в текстовые метки
            secondText.text = shuffledList[0]
            thirdText.text = shuffledList[1]
            forthText.text = shuffledList[2]
        }
    }
}