package com.android.alertdialog

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper

import android.view.View
import android.widget.EditText
import android.widget.LinearLayout

import androidx.appcompat.app.AlertDialog
import android.widget.Toast
import java.util.Arrays

//import android.view.LayoutInflater

class MainActivity : AppCompatActivity() {

    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            applicationContext,
            "SELECCIONO NO", Toast.LENGTH_SHORT
        ).show()
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            applicationContext,
            "SELECCIONO SI", Toast.LENGTH_SHORT
        ).show()
    }

    val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            applicationContext,
            "Maybe", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun basicAlert(view: View) {

        var builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Android Alert")
            setMessage("We have a message")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton("Cancelar", negativeButtonClick)
            setNeutralButton("Maybe", neutralButtonClick)
            show()
        }
    }


    fun withIconAndCustomise(view: View) {

        var builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Icon and Button Color")
            setMessage("We have a message")
            setPositiveButton("OK", null)
            setNegativeButton("Cancelar", null)
            setNeutralButton("Neutral", null)

            setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))

            setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_menu_call, theme))
        }

        val alertDialog = builder.create()
        alertDialog.show()

        val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        with(button)
        {
            setBackgroundColor(Color.BLACK)
            setPadding(0, 0, 20, 0)
            setTextColor(Color.WHITE)
        }

    }

    fun withItems(view: View){

        val items = arrayOf("Android", "Swift", "Flutter", "Xamarin", "React Native")

        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("List of Items")

            setItems(items) { dialog, wich ->
                Toast.makeText(applicationContext,
                    items[wich] + "fue seleccionado: ", Toast.LENGTH_SHORT).show()
            }

            setPositiveButton("OK", positiveButtonClick)
            show()
        }
    }

    fun withMultiChoiceList(view: View) {
        val items = arrayOf("Android", "Swift", "Flutter", "Xamarin", "React Native")

        val selectedList = ArrayList<Int>()

        val builder = AlertDialog.Builder(this)

        builder.setTitle("Lista de opciones multiple")
        builder.setMultiChoiceItems(items, null)
        { dialog, wich, isCheked ->
                if(isCheked){
                    selectedList.add(wich)
                }
            else if(selectedList.contains(wich)) {
                selectedList.remove(Integer.valueOf(wich))
            }
        }

        builder.setPositiveButton("Aceptar")
        { dialogInterface, i ->

            val selectedStrings = ArrayList<String>()

            for (j in selectedList.indices) {
                selectedStrings.add(items[selectedList[j]])
            }

            Toast.makeText(applicationContext,
                "Items seleccionados: " + Arrays.toString(selectedStrings.toTypedArray()),
                Toast.LENGTH_SHORT).show()

        }

        builder.show()
    }

    fun withStyle(view: View){

        val builder = AlertDialog.Builder(ContextThemeWrapper(this, android.R.style.Holo_Light_SegmentedButton))

        with(builder)
        {
            setTitle("Android Alert con style de android theme")
            setMessage("We have a message")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton("Cancelar", negativeButtonClick)
            setNeutralButton("Maybe", neutralButtonClick)
            show()
        }
    }

    fun withCustomStyle(view: View){

        val builder = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AlertDialogCustom))

        with(builder)
        {
            setTitle("Android Alert con style custom")
            setMessage("We have a message")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton("Cancelar", negativeButtonClick)
            setNeutralButton("Maybe", neutralButtonClick)
            show()
        }

    }

    fun withButtonCentered(view: View){

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Tutulo de la Alerta")
        alertDialog.setMessage("ALerta con acciones")

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "De Acuerdo")
        {
                dialog, wich -> dialog.dismiss()
        }

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar")
        {
            dialog, wich -> dialog.dismiss()
        }

        alertDialog.show()

        val btnPositiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegativeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParameter = btnPositiveButton.layoutParams as LinearLayout.LayoutParams
        layoutParameter.weight = 10f

        btnPositiveButton.layoutParams = layoutParameter
        btnNegativeButton.layoutParams = layoutParameter

    }

    fun withEditText(view: View){

        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater

        builder.setTitle("Inflater - Edit Text")

        val dialogLayout = inflater.inflate(R.layout.alert_dialog_with_edittext, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)

        builder.setView(dialogLayout)
        builder.setPositiveButton("De Acuerdo")
        {
            dialogInterface, i -> Toast.makeText(applicationContext, "EditText is ${editText.text}", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

}