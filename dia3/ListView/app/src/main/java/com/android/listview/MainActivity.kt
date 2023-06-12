package com.android.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv1 = findViewById<TextView>(R.id.tv1)

        val list1 = findViewById<ListView>(R.id.list1)

        val paises = arrayOf("Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay")
        val habitantes = arrayOf(40_000_000, 17_000_000, 6_500_000, 10_000_000, 30_000_000, 14_000_000, 183_000_000, 44_000_000, 31_000_000, 3_500_000)

        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paises)
        list1.adapter = adaptador

        list1.setOnItemClickListener { AdapterView,  view, i, l ->

            tv1.text = "Poblacion de: ${ habitantes[i]}"

        }


    }
}