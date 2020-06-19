package com.example.queueup.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.view.RestaurantDetailsActivity
import kotlinx.android.synthetic.main.card_restaurante.view.*

class RestAdapter(
    val context: Context,
    private val restaurantes: MutableList<RestaurantHeaderModel>
) :
    RecyclerView.Adapter<RestAdapter.RestViewHolder>() {

    //private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_restaurante, parent, false)
        return RestViewHolder(view)
    }

    override fun getItemCount(): Int = restaurantes.size

    override fun onBindViewHolder(holder: RestViewHolder, position: Int) {
        holder.bind(restaurantes[position])
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, RestaurantDetailsActivity::class.java))
        }


    }

    inner class RestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurante: RestaurantHeaderModel) {
            with(restaurante) {
                itemView.tv_restaurante_nome.text = name
                itemView.tv_restaurante_tipo.text = type


            }
        }
    }
}