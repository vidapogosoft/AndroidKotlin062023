package com.android.notifytoastsnackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btntoast = findViewById<Button>(R.id.btoast)
        val btnsnack = findViewById<Button>(R.id.bsnack)

        btntoast.setOnClickListener{

            Toast.makeText(this, "YOUR MESSAGES", Toast.LENGTH_SHORT).show()

        }

        btnsnack.setOnClickListener{

            Snackbar.make(it,"Mensaje Snack", Snackbar.LENGTH_SHORT).show()

        }

    }
}