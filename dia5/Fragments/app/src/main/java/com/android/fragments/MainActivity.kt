package com.android.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frgListado = supportFragmentManager.findFragmentById(R.id.frgListado)
                as FragmentListado

        frgListado.setCorreosListener{

            val frgDetalle: Fragment?
            = supportFragmentManager.findFragmentById(R.id.frgDetalle)

            if(frgDetalle != null)
            {
                (frgDetalle as FragmentDetalle).mostrarDetalle(it.texto)
            }
            else
            {
                val i = Intent(this, DetalleActivity::class.java)
                i.putExtra(DetalleActivity.Extra_Texto, it.texto)
                startActivity(i)
            }

        }

    }
}