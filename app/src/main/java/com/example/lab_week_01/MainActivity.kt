package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val greetingsDisplay = findViewById<TextView>(R.id.greetings_display)
        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val nimInput = findViewById<TextInputEditText>(R.id.nim_input)?.text.toString().trim()

            if(nameInput.isNotEmpty() && nimInput.isNotEmpty() && nimInput.length == 11 && isNumber(nimInput)){
                greetingsDisplay?.text =  getString(R.string.greetings).plus("Your name is : ").plus(nameInput)
                    .plus("\nYour NIM is : ").plus(nimInput)
// or you can use
// nameDisplay?.text = "${getString(R.string.name_greet)} ${nameInput}"
            }
            else {
                if(nameInput.isEmpty()) {
                    Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                if(nimInput.isEmpty()) {
                    Toast.makeText(this, getString(R.string.nim_empty), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                if(nimInput.isNotEmpty() && nimInput.length != 11 && isNumber(nimInput)) {
                    Toast.makeText(this, getString(R.string.nim_length_error), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
                if(!isNumber(nimInput)) {
                    Toast.makeText(this, getString(R.string.nim_not_number), Toast.LENGTH_LONG)
                        .apply {
                            setGravity(Gravity.CENTER, 0, 0)
                            show()
                        }
                }
            }
        }
    }

    fun isNumber(value: String): Boolean {
        return value.all { it.isDigit() }
    }
}