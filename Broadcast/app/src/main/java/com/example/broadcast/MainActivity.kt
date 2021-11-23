package com.example.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity: AppCompatActivity() {
    private lateinit var sendMessageButton: Button


    companion object {
        const val SEND_CAT_ACTION: String = "my.action.SEND_CAT"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendMessageButton = findViewById(R.id.send_message_button)

        sendMessageButton.setOnClickListener {
            val intent = Intent()
                .setAction(SEND_CAT_ACTION)
                .putExtra("my.broadcast.Message", getString(R.string.send_cat))
                .addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                .setClass(this, MessageReceiver::class.java)
            sendBroadcast(intent)
        }
    }
}
