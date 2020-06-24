package com.example.queueup.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.queueup.R
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.view.RestaurantListActivity
import kotlinx.android.synthetic.main.card_restaurante.view.*

class RestAdapter(
    var restaurantes: MutableList<RestaurantHeaderModel>,
    var clickListener: RestaurantListActivity
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
        holder.bind(restaurantes.get(position), clickListener)
//        holder.itemView.setOnClickListener {
//            context.startActivity(Intent(context, RestaurantDetailsActivity::class.java))
//        }


    }

    class RestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nomeRest = itemView.findViewById<TextView>(R.id.tv_restaurante_nome)
        var tipoRest = itemView.findViewById<TextView>(R.id.tv_restaurante_tipo)
        var imagemRest = itemView.findViewById<ImageView>(R.id.iv_imagem_rest)


        fun bind(restaurante: RestaurantHeaderModel, action: OnClickItem) {
            with(restaurante) {
                nomeRest.text = restaurante.name
                tipoRest.text = restaurante.type
                Glide.with(itemView.iv_imagem_rest).load(imagem).placeholder(R.drawable.america)
                    .error(R.drawable.america)
                    .into(itemView.iv_imagem_rest)

                itemView.setOnClickListener {
                    action.onItemClick(restaurante, adapterPosition)
                }

            }
        }
    }

    interface OnClickItem {
        fun onItemClick(restaurante: RestaurantHeaderModel, position: Int)
    }
}