package com.example.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.fragment.CatInfoFragment

class MainActivity: AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onButtonSelected(buttonIndex: Int) {
        val catInfoFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_cat_info) as CatInfoFragment?

        if (catInfoFragment != null && catInfoFragment.isVisible)
            catInfoFragment.setDescription(buttonIndex)
        else {
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("buttonIndex", buttonIndex)
            startActivity(intent)
        }
    }
}
