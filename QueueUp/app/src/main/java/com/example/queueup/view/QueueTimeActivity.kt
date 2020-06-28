package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.viewmodel.FilaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_queue_time.*

class QueueTimeActivity : AppCompatActivity() {

    private lateinit var mViewModel: FilaViewModel
    private lateinit var mShared: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue_time)
        setSupportActionBar(findViewById(R.id.toolbar_userhomepage))

        mViewModel = ViewModelProviders.of(this).get(FilaViewModel::class.java)
        //configurações do menu
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation).also {
            it.selectedItemId = R.id.navigationFila

        }

       // val user = mShared.get(TaskConstants.SHARED.ID_CLIENTE)

        //val idRest = intent.extras!!.get("idRest")
        val posicaoFila = intent.extras!!.getInt("posicaoFila")
        posicao_fila.text = posicaoFila.toString()



      //  posicao_fila.text = mViewModel.atualizaPosicao("${idRest}", user).toString()

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.navigationFila -> {
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
    }
}