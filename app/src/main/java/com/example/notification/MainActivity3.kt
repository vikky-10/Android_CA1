package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notification.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main3)
btnSubmit.setOnClickListener{
    var msg=ratingBar.rating.toString()+"Thank you 🎉🎉"
    Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
}
//        binding.btnSubmit.setOnClickListener {
//            val msg = binding.ratingBar.rating.toString()
//            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//        }
    }

}