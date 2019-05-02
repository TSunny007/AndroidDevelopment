package com.example.animations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var bartIsShowing = true

    fun fade(view: View) {
        Log.i("Info", "Imageview has been tapped.")

        val bartImageView = findViewById<ImageView>(R.id.bartImageView)
        val homerImageView = findViewById<ImageView>(R.id.homerImageView)

        if (bartIsShowing) {
            bartIsShowing = false
            bartImageView.animate().alpha(0f).duration = 2000
            homerImageView.animate().alpha(1f).duration = 2000
        } else {
            bartIsShowing = true
            homerImageView.animate().alpha(0f).duration = 2000
            bartImageView.animate().alpha(1f).duration = 2000
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
