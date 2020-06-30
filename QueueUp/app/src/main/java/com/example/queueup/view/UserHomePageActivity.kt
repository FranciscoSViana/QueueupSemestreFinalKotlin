package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.adapters.AlphaAdapters
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.viewmodel.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_user_home_page.*

class UserHomePageActivity : AppCompatActivity(), View.OnClickListener {
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var arrayList: ArrayList<AlphaChar>? = null
    private var alphaAdapters: AlphaAdapters? = null

    private lateinit var mViewModel: UserHomePageViewModel
    private lateinit var viewModel: FilaViewModel
    private lateinit var mShared: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home_page)
        //configurações do menu
        setSupportActionBar(findViewById(R.id.toolbar_userhomepage))
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation).also {
            it.selectedItemId = R.id.navigationRestaurant
        }

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.navigationFila -> {

                    val posicaoFila = intent.extras!!.getInt("posicaoFila")
                    val intent = Intent(this, QueueTimeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigationRestaurant ->{
                    val intent2 = Intent(this, UserHomePageActivity::class.java)
                    startActivity(intent2)
                    true
                }
                else -> false
            }
        }


        mViewModel = ViewModelProvider(this).get(UserHomePageViewModel::class.java)

        recyclerView = findViewById(R.id.recyclerview_id)
        gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters



        //mViewModel.listSpecialities()
    }

    private fun setDataInList(): ArrayList<AlphaChar> {
        var items: ArrayList<AlphaChar> = ArrayList()

        items.add(AlphaChar(R.drawable.francesa, "Todos os Restaurantes"))
        items.add(AlphaChar(R.drawable.italiana, "Italiana"))
        items.add(AlphaChar(R.drawable.americana, "Hamburgueria"))
        items.add(AlphaChar(R.drawable.japonesa, "Japonesa"))
        items.add(AlphaChar(R.drawable.brasileira, "Brasileira"))
        items.add(AlphaChar(R.drawable.sobremesa, "Sobremesa"))
        return items
    }

    //    private fun observe() {
//        mViewModel.specialityList.observe(this, Observer {
//
//            val list: MutableList<String> = ArrayList()
//            for (p in it) {
//                p.type?.let { it1 -> list.add(it1) }
//
//
//            }
//        })
//    }

    fun activity(v: View) {
        startActivity(Intent(this, CardViewRestaurantActivity::class.java))
    }

    //
    override fun onClick(v: View) {
        if (v.id == R.id.recyclerview_id) {
            startActivity(Intent(this, CardViewRestaurantActivity::class.java))
        }
    }

}






