package com.android.sqlite

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etCod = findViewById<EditText>(R.id.TxtCodigo)
        val etDesc = findViewById<EditText>(R.id.TxtDescripcion)
        val etPrecio = findViewById<EditText>(R.id.TxtPrecio)

        val tvResultado = findViewById<TextView>(R.id.TxtResultado)

        val BtnSave = findViewById<Button>(R.id.BtnSave)
        val BtnUpd = findViewById<Button>(R.id.BtnUpd)
        val BtnDel = findViewById<Button>(R.id.BtnDel)
        val BtnConsId = findViewById<Button>(R.id.BtnConsId)
        val BtnConsDesc = findViewById<Button>(R.id.BtnConsDesc)

        BtnConsDesc.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "productos", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select codigo,precio,secuencial from articulos where descripcion like ${"'%"+etDesc.text.toString()+"%'"}", null)

            if(fila.moveToFirst())
            {
                etCod.setText(fila.getString(0))
                etPrecio.setText(fila.getString(1))
                tvResultado.setText(fila.getString(2))
            }
            else
            {
                tvResultado.setText("No existen resultados para la descripcion: " + "-" + etDesc.getText().toString())
            }
            bd.close()
        }

        BtnConsId.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "productos", null, 1)
            val bd = admin.writableDatabase

            val fila = bd.rawQuery("select descripcion,precio,secuencial from articulos where codigo = ${etCod.text.toString()}", null)


            if(fila.moveToFirst())
            {
                etDesc.setText(fila.getString(0))
                etPrecio.setText(fila.getString(1))
                tvResultado.setText(fila.getString(2))
            }
            else
            {
                tvResultado.setText("No existen resultados para el codigo: " + "-" + etCod.getText().toString())
            }
            bd.close()

        }

        BtnSave.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "productos", null, 1)
            val bd = admin.writableDatabase

            val registro = ContentValues()
            registro.put("codigo", etCod.getText().toString())
            registro.put("descripcion", etDesc.getText().toString())
            registro.put("precio", etPrecio.getText().toString())

            val save = bd.insert("articulos", null, registro)
            bd.close()

            if(save > 0)
            {
                tvResultado.setText(save.toString() + "-" + etDesc.getText())
                Toast.makeText(this, "Registro ingresado: " + etDesc.getText(), Toast.LENGTH_LONG )
            }
            else{
                Toast.makeText(this, "Error en Registro", Toast.LENGTH_SHORT )
            }

            etCod.setText("")
            etDesc.setText("")
            etPrecio.setText("")

        }

        BtnUpd.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "productos", null, 1)
            val bd = admin.writableDatabase

            val registro = ContentValues()

            registro.put("descripcion", etDesc.getText().toString())
            registro.put("precio", etPrecio.getText().toString())

            val comp = bd.update("articulos",registro, "secuencial=${tvResultado.text}", null )

            if(comp == 1)
            {
                tvResultado.setText(etDesc.getText())
                Toast.makeText(this, "Registro actualizado" , Toast.LENGTH_LONG )
            }
            else{
                Toast.makeText(this, "Error en Registro", Toast.LENGTH_SHORT )
            }

        }

        BtnDel.setOnClickListener {

            val admin = AdminSQLiteOpenHelper(this, "productos", null, 1)
            val bd = admin.writableDatabase

            val comp = bd.delete("articulos","secuencial=${tvResultado.text}", null )

            if(comp == 1)
            {
                tvResultado.setText(etDesc.getText().toString() + "-" + "Eliminado")
                Toast.makeText(this, "Registro borrado" , Toast.LENGTH_LONG )
            }
            else{
                Toast.makeText(this, "Error en Registro", Toast.LENGTH_SHORT )
            }

            etCod.setText("")
            etDesc.setText("")
            etPrecio.setText("")

        }

    }
}