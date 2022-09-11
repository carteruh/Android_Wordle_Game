package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.TextInput)
        val button = findViewById<Button>(R.id.button)
        val answer = findViewById<TextView>(R.id.Answer)
        val ans1 = findViewById<TextView>(R.id.AnsOne)
        val ans1Check = findViewById<TextView>(R.id.AnsOneCheck)
        val ans2 = findViewById<TextView>(R.id.AnsTwo)
        val ans2Check = findViewById<TextView>(R.id.AnsTwoCheck)
        val ans3 = findViewById<TextView>(R.id.AnsThree)
        val ans3Check = findViewById<TextView>(R.id.AnsThreeCheck)
        var ansString = FourLetterWordList.getRandomFourLetterWord().toString().uppercase()
        answer.text = ansString
        input.setOnClickListener{

            button.setOnClickListener {
                var stringText = input.text.toString().uppercase()

                if (count == 1){
                    ans1.text = stringText
                    ans1.visibility = View.VISIBLE
                    ans1Check.text = checkGuess(stringText, ansString)
                    ans1Check.visibility = View.VISIBLE
                    count++
                }
                else if (count == 2){
                    ans2.text = stringText
                    ans2.visibility = View.VISIBLE
                    ans2Check.text = checkGuess(stringText, ansString)
                    ans2Check.visibility = View.VISIBLE
                    count++
                }
                else if (count == 3){
                    ans3.text = stringText
                    ans3.visibility = View.VISIBLE
                    ans3Check.text = checkGuess(stringText, ansString)
                    ans3Check.visibility = View.VISIBLE
                    answer.visibility = View.VISIBLE
                    button.isEnabled = false
                    button.setBackgroundColor(808080)
                    count ++
                }

            }
        }

    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String,wordToGuess: String) : String {
        var result = ""

        for (i in 0..3) {
            if (guess[i].uppercase() == wordToGuess[i].uppercase()) {
                result += "O"
            }
            else if (guess[i].uppercase() in wordToGuess.uppercase()) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}