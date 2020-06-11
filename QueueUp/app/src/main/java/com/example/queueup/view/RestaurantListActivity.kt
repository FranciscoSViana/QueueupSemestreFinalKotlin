package com.example.queueup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.adapters.RestauranteAdapter
import com.example.tasks.ItemRestaurante

class RestaurantListActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<ItemRestaurante>? = null
    private var alphaAdapters: RestauranteAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)


        recyclerView = findViewById(R.id.id_recyclerview)
        gridLayoutManager = GridLayoutManager(
            applicationContext, 1,
            LinearLayoutManager.VERTICAL, false
        )
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = RestauranteAdapter(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters

    }

    private fun setDataInList(): ArrayList<ItemRestaurante> {
        var items: ArrayList<ItemRestaurante> = ArrayList()


        //Icone, Status, Nome, Culinaria (Tipo), Distancia
        items.add(
            ItemRestaurante(
                R.drawable.america,
                R.drawable.bolinhaamarela,
                "Nome do Restaurante",
                "Tipo de Culinaria",
                "Distancia em KM (STRING)",
                "10 mesas"
            )
        )
        items.add(
            ItemRestaurante(
                R.drawable.america,
                R.drawable.bolinhaverde,
                "Nome do Restaurante",
                "Tipo de Culinaria",
                "Distancia em KM (STRING)",
                "5 mesas"
            )
        )
        items.add(
            ItemRestaurante(
                R.drawable.america,
                R.drawable.bolinhavermelha,
                "Nome do Restaurante",
                "Tipo de Culinaria",
                "Distancia em KM (STRING)",
                "7 mesas"
            )
        )
        items.add(
            ItemRestaurante(
                R.drawable.america,
                R.drawable.bolinhaamarela,
                "Nome do Restaurante",
                "Tipo de Culinaria",
                "Distancia em KM (STRING)",
                "4 mesas"
            )
        )



        return items
    }
}

