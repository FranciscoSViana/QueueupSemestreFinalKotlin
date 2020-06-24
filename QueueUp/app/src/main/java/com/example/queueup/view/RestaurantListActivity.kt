package com.example.queueup.view

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.adapters.RestAdapter
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.utils.SaveData
import com.example.queueup.viewmodel.SearchRestaurantViewModel
import com.example.tasks.ItemRestaurante
import kotlinx.android.synthetic.main.activity_restaurant_list.*

class RestaurantListActivity : AppCompatActivity(), RestAdapter.OnClickItem {
    private lateinit var viewModel: SearchRestaurantViewModel
    private lateinit var mSharedPreferences: SaveData
    private lateinit var mProgress: ProgressDialog

    //    private var recyclerView: RecyclerView? = null
//    private var gridLayoutManager: GridLayoutManager? = null
//    private var arrayList: ArrayList<ItemRestaurante>? = null
//    private var alphaAdapters: RestauranteAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var arrayList: MutableList<RestaurantHeaderModel>? = null
    private var linearLayoutManager: LinearLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        viewModel = ViewModelProviders.of(this).get(SearchRestaurantViewModel::class.java)
        viewModel.restaurants.observe(this, Observer {
            it?.let { restaurante ->
                with(id_recyclerview) {
                    layoutManager =
                        LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
                    adapter =
                        RestAdapter(

                            restaurante as MutableList<RestaurantHeaderModel>,
                            context as RestaurantListActivity
                        )
                }
            }
        })

//        recyclerView = findViewById(R.id.id_recyclerview)
//        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        recyclerView?.layoutManager = linearLayoutManager
//        recyclerView?.setHasFixedSize(true)
//        // arrayList = MutableList()
//        recyclerView?.adapter = RestAdapter(arrayList!!, this)


        mSharedPreferences = SaveData(this)
        val str = mSharedPreferences.get()
//        mProgress = ProgressDialog(this)
//        mProgress.setMessage("Buscando...")
//        mProgress.show()
        Log.d("nome: ", str)
        if (str != "Todos os Restaurantes") {
            viewModel.getRestaurante(str)
            //  mProgress.hide()
        } else {
            viewModel.all()
            //  mProgress.hide()
        }

//
//        recyclerView = findViewById(R.id.id_recyclerview)
//        gridLayoutManager = GridLayoutManager(
//            applicationContext, 1,
//            LinearLayoutManager.VERTICAL, false
//        )
//        recyclerView?.layoutManager = gridLayoutManager
//        recyclerView?.setHasFixedSize(true)
//        arrayList = ArrayList()
//        arrayList = setDataInList()
//        alphaAdapters = RestauranteAdapter(applicationContext, arrayList!!)
//        recyclerView?.adapter = alphaAdapters

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

    override fun onItemClick(restaurante: RestaurantHeaderModel, position: Int) {
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("nomeRest", restaurante.name)
        intent.putExtra("telRest", restaurante.telephone)
        intent.putExtra("logRest", restaurante.street)
        intent.putExtra("numRest", restaurante.number)
        intent.putExtra("bairroRest", restaurante.district)
        intent.putExtra("cidadeRest", restaurante.city)
        intent.putExtra("estadoRest", restaurante.state)
        intent.putExtra("tipoRest", restaurante.type)
        intent.putExtra("imagemRest", restaurante.imagem)
        intent.putExtra("logoRest", restaurante.logo)

        startActivity(intent)
    }
}

