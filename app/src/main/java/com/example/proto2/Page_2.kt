package com.example.proto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Page_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        //Visual Elements
        val enterNextAdd = findViewById<EditText>(R.id.enterNextAdd)
        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        val finishRouteButton = findViewById<Button>(R.id.finishRouteButton)

        //Assigning last address
        var displayAdd = intent.getStringExtra("Last")
        val displayLastAdd = findViewById<TextView>(R.id.displayLastAdd).apply {
            text = displayAdd.toString()
        }

        // Pulling Array List
        var addressList = intent.getStringArrayListExtra("addList")
        // Pulling Reorder and Repeat values
        var checkReorderBool = intent.getStringExtra("Reorder")
        var checkRepeatFirstBool = intent.getStringExtra("RepeatFirst")

        nextPageButton.setOnClickListener {
            //adding to list, and checking if empty
            if (enterNextAdd.text.toString() != "") {
                var enteredAdd = enterNextAdd.text.toString()
                if (addressList != null) {
                    addressList.add(enteredAdd)
                }

                //establishing last address
                var lastAddress = addressList?.get((addressList.size) - 1)
                val intent = Intent(this, Page_3::class.java)
                intent.putExtra("Last", lastAddress)
                intent.putStringArrayListExtra("addList", addressList)
                intent.putExtra("Reorder", checkReorderBool)
                intent.putExtra("RepeatFirst", checkRepeatFirstBool)
                startActivity(intent)
            }
        }

        finishRouteButton.setOnClickListener {
            //adding to list, and checking if empty
            if (enterNextAdd.text.toString() != "") {
                var enteredAdd = enterNextAdd.text.toString()
                if (addressList != null) {
                    addressList.add(enteredAdd)
                }
            }
            if (checkRepeatFirstBool == "1") {
                var firstAdd = addressList?.get(0)
                if (addressList != null) {
                    addressList.add(firstAdd)
                }
            }
                val intent = Intent(this, Display_Page::class.java)
                intent.putStringArrayListExtra("addList", addressList)
                intent.putExtra("Reorder", checkReorderBool)
                intent.putExtra("RepeatFirst", checkRepeatFirstBool)
                startActivity(intent)
            }

        }
    }

