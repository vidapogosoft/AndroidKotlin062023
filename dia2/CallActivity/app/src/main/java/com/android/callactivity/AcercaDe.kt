package com.android.callactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button


class AcercaDe : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        val BotonSalir = findViewById<Button>(R.id.BtnSalir)

        BotonSalir.setOnClickListener {

            finish()

        }

    }

}