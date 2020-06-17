package com.example.queueup.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.view.RestaurantDetailsActivity
import com.example.tasks.ItemRestaurante

class RestauranteAdapter(var context: Context, var arrayList: ArrayList<ItemRestaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_card_view_restaurant, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var itemRestaurante: ItemRestaurante = arrayList.get(position)
        holder.iconeRestaurante.setImageResource(itemRestaurante.iconeRestaurante!!)
        holder.statusRestaurante.setImageResource(itemRestaurante.statusRestaurante!!)
        holder.nomeRestaurante.text = itemRestaurante.nomeRestaurante
        holder.culinariaRestaurante.text = itemRestaurante.culinariaRestaurante
        holder.distanciaRestaurante.text = itemRestaurante.distanciaRestaurante
        holder.tempoFila.text = itemRestaurante.tempoFila
        holder.nomeRestaurante.setOnClickListener {
            Toast.makeText(context, itemRestaurante.nomeRestaurante, Toast.LENGTH_LONG).show()
            context.startActivity(Intent(context, RestaurantDetailsActivity::class.java))
        }
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iconeRestaurante = itemView.findViewById<ImageView>(R.id.imagemRestaurante)
        var statusRestaurante = itemView.findViewById<ImageView>(R.id.bolinha)
        var nomeRestaurante = itemView.findViewById<TextView>(R.id.nomeRestaurante)
        var culinariaRestaurante = itemView.findViewById<TextView>(R.id.culinariaRestaurante)
        var distanciaRestaurante = itemView.findViewById<TextView>(R.id.distanciaRestaurante)
        var tempoFila = itemView.findViewById<TextView>(R.id.tempoFila)
    }

}