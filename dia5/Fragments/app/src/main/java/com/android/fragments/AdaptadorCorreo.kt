package com.android.fragments

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

data class Correo(val de: String, val asunto: String, val texto: String)

class AdaptadorCorreo (
    private val datos: MutableList<Correo>,
    private val clickListener : (Correo) -> Unit) :
        RecyclerView.Adapter<AdaptadorCorreo.CorreosViewHolder>(){

        class CorreosViewHolder(val item: View) :RecyclerView.ViewHolder(item){

            val lblDe = item.findViewById(R.id.lblDe) as TextView
            val lblAsunto = item.findViewById(R.id.lblAsunto) as TextView

        fun bindCorreo(correo: Correo)
        {
            lblDe.text = correo.de
            lblAsunto.text = correo.asunto
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorreosViewHolder {

        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_correo, parent, false) as LinearLayout

        return CorreosViewHolder(item)
    }

    override fun onBindViewHolder(holder: CorreosViewHolder, position: Int) {
        val correo = datos[position]

        holder.bindCorreo(correo)

        holder.item.setOnClickListener { clickListener(correo) }
    }
    override fun getItemCount() = datos.size
        }
