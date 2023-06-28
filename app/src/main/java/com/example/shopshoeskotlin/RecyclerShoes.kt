package com.example.shopshoeskotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerShoes(var context: Home,var listaShoes:MutableList<Shoes>):RecyclerView.Adapter<RecyclerShoes.MiHolder>() {


    inner class MiHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var labelNombre: TextView
        lateinit var imageShoes: ImageView
        lateinit var labelPrice: TextView

        init{
            labelNombre = itemView.findViewById(R.id.labelShoes)
            imageShoes = itemView.findViewById(R.id.imageShoes)
            labelPrice = itemView.findViewById(R.id.labelPrices)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.carta_shoes,parent, false)
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaShoes.size
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        var shoe = listaShoes[position]

        holder.labelNombre.text = shoe.nombre
        holder.labelPrice.text = shoe.precio
        Glide.with(context).load(shoe.url).into(holder.imageShoes)
    }
}