package com.android.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    companion object {
        val Extra_Texto : String = "com.android.fragments"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val detalle = supportFragmentManager.findFragmentById(R.id.frgDetalle)
                as FragmentDetalle

        //detalle.mostrarDetalle(intent.getStringExtra(Extra_Texto))
        detalle.mostrarDetalle(intent.getStringExtra(Extra_Texto).toString())

    }
}