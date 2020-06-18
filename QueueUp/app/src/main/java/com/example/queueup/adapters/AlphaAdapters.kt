package com.example.queueup.adapters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.utils.SaveData
import com.example.queueup.view.CardViewRestaurantActivity
import com.example.queueup.view.RestaurantListActivity
import com.example.queueup.viewmodel.AlphaChar
import kotlinx.android.synthetic.main.nav_header_main.view.*

class AlphaAdapters(var context: Context, var arrayList: ArrayList<AlphaChar>) :
    RecyclerView.Adapter<AlphaAdapters.ItemHolder>() {

    private lateinit var mSharedPreferences: SaveData


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_categorias, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var alphaChar: AlphaChar = arrayList.get(position)
        holder.icons.setImageResource(alphaChar.iconsChar!!)
        holder.alphas.text = alphaChar.alphaChar
        holder.icons.setOnClickListener {
            mSharedPreferences = SaveData(context.applicationContext)
            Toast.makeText(context, alphaChar.alphaChar, Toast.LENGTH_SHORT).show()
            mSharedPreferences.store(holder.alphas.text.toString())
            context.startActivity(Intent(context, RestaurantListActivity::class.java))


        }
    }


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icons = itemView.findViewById<ImageView>(R.id.imagem_categoria)
        var alphas = itemView.findViewById<TextView>(R.id.tv_nomeCategorias)
    }


}
