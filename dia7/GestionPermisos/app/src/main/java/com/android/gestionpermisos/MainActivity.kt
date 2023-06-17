package com.android.gestionpermisos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMARA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCamera=findViewById<Button>(R.id.btnCamera)

        btnCamera.setOnClickListener { checkCameraPermission() }
    }

    private fun checkCameraPermission()
    {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED )
        {
            Toast.makeText(this, "Permiso NO aceptado",
                Toast.LENGTH_SHORT).show()

            requestCameraPermission()
        }
        else{
            Toast.makeText(this, "Permiso SI esta aceptado",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun requestCameraPermission(){

        if(ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.CAMERA
        ))
        {
            Toast.makeText(this, "El usuario ya ha rechazado el permiso " +
                    "anteriormente, debemos informarle que vaya a ajustes.",
                Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "El usuario nunca ha aceptado " +
                    "ni rechazado, así que le pedimos que acepte el permiso.",
                Toast.LENGTH_SHORT).show()

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
            CAMARA_REQUEST_CODE)

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode)
        {
            CAMARA_REQUEST_CODE -> {
                if((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED))
                {
                    Toast.makeText(this, "El usuario ha aceptado el permiso, no tiene porqué darle de nuevo " +
                            "al botón, podemos lanzar la funcionalidad desde aquí.",
                        Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "El usuario ha rechazado el permiso, podemos desactivar la " +
                            "funcionalidad o mostrar una vista/diálogo.", Toast.LENGTH_SHORT).show()
                }
                return
            }
            else -> {
                Toast.makeText(this, "Este else lo dejamos por si sale un permiso que no " +
                        "teníamos controlado.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}