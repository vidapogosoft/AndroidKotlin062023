package com.android.callactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 = findViewById<Button>(R.id.boton1)

        boton1.setOnClickListener {

            val intent1 = Intent(this, AcercaDe::class.java)

            startActivity(intent1)

        }


    }
}