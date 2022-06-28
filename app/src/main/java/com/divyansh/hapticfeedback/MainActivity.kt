package com.divyansh.hapticfeedback

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var clickBtn: Button
    private lateinit var pressBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickBtn = findViewById(R.id.click_btn)
        pressBtn = findViewById(R.id.press_btn)

        clickBtn.setOnClickListener {
            click(it.context)
        }

        pressBtn.setOnClickListener {
            press(it.context)
        }
    }
}