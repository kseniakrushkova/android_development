package com.example.toast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe (view: View){
        val  myToast = Toast.makeText(this,"Пора кормить кота!",Toast.LENGTH_SHORT)

        myToast.show()
    }
}