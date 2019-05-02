package com.example.animations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var peeking = false

    fun fade(view: View) {
        Log.i("Info", "Imageview has been tapped.")

        val bartImageView = findViewById<ImageView>(R.id.bartImageView)
        if (!peeking) {
            bartImageView.animate().translationYBy(1000f).duration = 2000
        } else {
            bartImageView.animate().translationYBy(-1000f).duration = 2000
        }
        peeking = !peeking

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bartImageView = findViewById<ImageView>(R.id.bartImageView)
        bartImageView.x = -1000f
        bartImageView.animate().translationXBy(1000f).rotation(3600f).duration = 2000
    }
}
