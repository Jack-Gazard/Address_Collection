package com.example.proto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Visual elements
        val enterAdd1 = findViewById<EditText>(R.id.enterAdd1)
        var checkReorder = findViewById<CheckBox>(R.id.checkReorder)
        val sendAdd1 = findViewById<Button>(R.id.sendAdd1)
        var checkRepeatFirst = findViewById<CheckBox>(R.id.checkRepeatFirst)
        // Set array list and last address variable
        var addressList = ArrayList<String>()






        sendAdd1.setOnClickListener {
            // entered address 1 from text box
            var add1 = enterAdd1.text.toString()
            //adding address to array
            addressList.add(add1)
            // declaring last address
            var lastAddress = addressList[(addressList.size) - 1]
            //Carrying tick box info
            // Reorder
            var checkReorderBool = "0"
            if(checkReorder.isChecked()) {
                checkReorderBool = "1"
            } else {
                checkReorderBool = "0"
            }
            // Repeat first
            var checkRepeatFirstBool = "0"
            if(checkRepeatFirst.isChecked()) {
                checkRepeatFirstBool = "1"
            } else {
                checkRepeatFirstBool = "0"
            }
            val intent = Intent(this, Page_2::class.java)
            intent.putExtra("Last", lastAddress)
            intent.putStringArrayListExtra("addList", addressList)
            intent.putExtra("Reorder", checkReorderBool)
            intent.putExtra("RepeatFirst", checkRepeatFirstBool)
            startActivity(intent)
        }
    }
}