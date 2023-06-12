package com.android.callactivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val et1=findViewById<EditText>(R.id.et1)
        val boton1=findViewById<Button>(R.id.btn1)

        boton1.setOnClickListener {

            val intent1 = Intent(this, Actividad2:: class.java)

            intent1.putExtra("direccion", et1.text.toString())

            startActivity(intent1)

        }
    }
}