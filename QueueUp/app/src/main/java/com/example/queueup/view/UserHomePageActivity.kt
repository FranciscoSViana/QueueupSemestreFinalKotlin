package com.example.queueup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.queueup.R
import com.example.queueup.adapters.AlphaAdapters
import com.example.queueup.viewmodel.AlphaChar

class UserHomePageActivity : AppCompatActivity() {
    private  var recyclerView:RecyclerView ? = null
    private var gridLayoutManager:GridLayoutManager ? = null
    private var arrayList:ArrayList<AlphaChar> ? = null
    private var alphaAdapters:AlphaAdapters ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home_page)
        setSupportActionBar(findViewById(R.id.toolbar_userhomepage))

        recyclerView = findViewById(R.id.recyclerview_id)
        gridLayoutManager = GridLayoutManager(applicationContext, 2,LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext, arrayList!!)
        recyclerView?.adapter = alphaAdapters

    }

    private fun setDataInList() : ArrayList<AlphaChar>{
        var items:ArrayList<AlphaChar> = ArrayList()

        items.add(AlphaChar(R.drawable.francesa, "Todos os Restaurantes"))
        items.add(AlphaChar(R.drawable.italiana, "Italiana"))
        items.add(AlphaChar(R.drawable.americana, "Hamburgueria"))
        items.add(AlphaChar(R.drawable.japonesa, "Japonesa"))
        items.add(AlphaChar(R.drawable.brasileira, "Brasileira"))
        items.add(AlphaChar(R.drawable.sobremesa, "Sobremesa"))
        return items
    }
}




