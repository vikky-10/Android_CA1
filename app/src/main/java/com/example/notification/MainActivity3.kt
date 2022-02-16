package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//        Todo: Rating bar
        btnSubmit.setOnClickListener{
        var msg=ratingBar.rating.toString()+"⭐ Thank you 🎉🎉"
         Toast(this).showCustomToast (msg, this)

        }
    }

}