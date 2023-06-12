package com.android.callactivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.webkit.WebView

class Actividad2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        val extra = intent.extras
        val dato = extra?.getString("direccion")
        val webView = findViewById<WebView>(R.id.wv1)
        webView.loadUrl("https://${dato}")

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener {
            finish();
        }

    }
}