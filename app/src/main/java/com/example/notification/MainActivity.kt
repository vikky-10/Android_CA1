package com.example.notification


import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.RemoteViews
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // declaring variables
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "vikky"
    private val description = "notification"
//    @SuppressLint("RemoteViewLayout")
    @SuppressLint("RemoteViewLayout")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#146775")))
    if (TextUtils.isEmpty(EditText.getText())) {
        EditText.setError(" Please Enter Email! ");
    }

val btn: Button = findViewById(R.id.Sing)

    btn.setOnClickListener {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }
    val btn1: Button = findViewById(R.id.gg_login)

    btn1.setOnClickListener {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)

    }


//Todo:    Notification Logic

    val btns = findViewById<Button>(R.id.not);
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this, MainActivity3::class.java)
    btns.setOnClickListener {
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT)
        val view = RemoteViews(packageName, R.layout.activity_main3)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this)
                .setContentTitle("👋👋👋 Hello, Android Notification")
                .setContentText("Tap and go to About us Page and Rate This app ⭐⭐⭐")
                .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                .setChannelId(channelId)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.ic_baseline_notifications_paused_24
                    )
                )
                .setContentIntent(pendingIntent)

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder = Notification.Builder(this)
                    .setContentTitle("👋👋 Hello, Android Notification")
                    .setContentText("Tap and go to About us Page and Rate This app ⭐⭐⭐")
                    .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
                    .setChannelId(channelId)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            this.resources,
                            R.drawable.ic_baseline_notifications_paused_24
                        )
                    )
                    .setContentIntent(pendingIntent)
            }
        }
        notificationManager.notify(1234, builder.build())

    }
}

}