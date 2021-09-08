package com.example.proto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Display_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_page)

        var addressList = intent.getStringArrayListExtra("addList")
        var checkReorderBool = intent.getStringExtra("Reorder")
        var checkRepeatFirstBool = intent.getStringExtra("RepeatFirst")

        val displayFinal = findViewById<TextView>(R.id.displayFinal).apply {
            text = addressList.toString()
        }
        val displayFinalRoutingType = findViewById<TextView>(R.id.displayFinalRoutingType).apply {
            text = checkReorderBool.toString()
        }
        val displayFinalRoutingRepeat = findViewById<TextView>(R.id.displayFinalRoutingRepeat).apply {
            text = checkRepeatFirstBool.toString()
        }
    }
}