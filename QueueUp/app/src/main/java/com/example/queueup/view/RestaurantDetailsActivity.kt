package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.viewmodel.FilaViewModel
import kotlinx.android.synthetic.main.activity_restaurant_details.*

class RestaurantDetailsActivity : AppCompatActivity() {


   private lateinit var idRest: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)
         val mSharedPreferences: SecurityPreferences = SecurityPreferences(applicationContext)


        val nomeRest = intent.extras!!.getString("nomeRest")
        tituloRestaurante.text = nomeRest
        val tipoRest = intent.extras!!.getString("tipoRest")
        tipoCulinaria.text = tipoRest
        val telRest = intent.extras!!.getString("telRest")
        telefoneRestaurante.text = telRest
        val logRest = intent.extras!!.getString("logRest")
        val numRest = intent.extras!!.getString("numRest")
        val bairroRest = intent.extras!!.getString("bairroRest")
        val cidadeRest = intent.extras!!.getString("cidadeRest")
        val estadoRest = intent.extras!!.getString("estadoRest")
        val imagemRest = intent.extras!!.getString("imagemRest")
        val logoRest = intent.extras!!.getString("logoRest")
        idRest = intent.extras!!.getString("idRestaurante").toString()

        mSharedPreferences.store(TaskConstants.SHAREDRESTAURANT.ID_RESTAURANTE, idRest)


        enderecoRestaurante.text =
            "${logRest} ${numRest} - ${bairroRest} ${cidadeRest}/${estadoRest}"

        entrarFila.setOnClickListener {
            val intent = Intent(this, FilaInfo::class.java)
            intent.putExtra("idRest", idRest)
            telaInfo(idRest,this)

        }

        cancelar.setOnClickListener {
            startActivity(Intent(this, RestaurantListActivity::class.java))
            finish()
        }

        println("nome:" + logoRest)
        if (logoRest != null) {
            Glide.with(this)
                .load(logoRest)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .dontAnimate()
                .into(imagemredonda);
        }

        if (imagemRest != null) {
            Glide.with(this)
                .load(imagemRest)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .dontAnimate()
                .into(iv_imagem_layout);
        }
    }
    private fun telaInfo(idRest: String,activity: RestaurantDetailsActivity){
        FilaViewModel().filaTotalRestaurante(idRest, activity)

    }

}