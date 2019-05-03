package com.example.connect3game

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    // red is 0, yellow is 1, unassigned = -10
    var state = IntArray(9) {_ -> -10}
    var disabled = false
    var redTurn = Random.nextBoolean()


    fun nextMove(view: View) {
        val counter = view as ImageView
        if(counter.drawable != null) return
        if(disabled) return

        counter.translationY = -1500f
        if (redTurn) {
            counter.setImageResource(R.drawable.red)
            state[Integer.parseInt(counter.getTag().toString())] = 0
        } else {
            counter.setImageResource(R.drawable.yellow)
            state[Integer.parseInt(counter.getTag().toString())] = 1
        }

        redTurn = !redTurn
        counter.animate().translationYBy(1500f).rotation(3600f + Random.nextInt(0..120)).duration = 300
        val boardStatus = checkWinner()
        if (boardStatus != -1) {
            disabled = true
            if (boardStatus == 0) {
                findViewById<TextView>(R.id.winnerMessage).text = "RED WINS!"
            } else {
                findViewById<TextView>(R.id.winnerMessage).text = "YELLOW WINS!"
            }
            findViewById<Button>(R.id.restart).visibility = View.VISIBLE
        }
        if (state.sum() > 0) {
            findViewById<TextView>(R.id.winnerMessage).text = "DRAW"
            findViewById<Button>(R.id.restart).visibility = View.VISIBLE
        }
    }

    fun restartGame(view: View) {
        recreate()
    }

    fun checkWinner(): Int {
        var sum = 0
        for (a in 0..7) {
            when(a) {
                0 -> {sum = state[0] + state[1] + state[2]}
                1 -> {sum = state[3] + state[4] + state[5]}
                2 -> {sum = state[6] + state[7] + state[8]}
                3 -> {sum = state[0] + state[3] + state[6]}
                4 -> {sum = state[1] + state[4] + state[7]}
                5 -> {sum = state[2] + state[5] + state[8]}
                6 -> {sum = state[0] + state[4] + state[8]}
                7 -> {sum = state[2] + state[4] + state[6]}
            }
            if (sum == 0) return 0
            if (sum == 3) return 1
        }
        return -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
