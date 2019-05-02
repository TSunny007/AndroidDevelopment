package com.example.connect3game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    // red is 0, yellow is 1
    var state = IntArray(9) {_ -> -1}

    var redTurn = Random.nextBoolean()
    fun nextMove(view: View) {
        val counter = view as ImageView
        if(counter.drawable != null) return

        counter.translationY = -1500f
        if (redTurn) {
            counter.setImageResource(R.drawable.red)
            state[Integer.parseInt(counter.getTag().toString())] = 0
        } else {
            counter.setImageResource(R.drawable.yellow)
            state[Integer.parseInt(counter.getTag().toString())] = 0
        }

        redTurn = !redTurn
        counter.animate().translationYBy(1500f).rotation(3600f + Random.nextInt(0..120)).duration = 300
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
