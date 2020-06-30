package com.example.queueup.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.viewmodel.FilaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_queue_time.*
import java.util.*

class QueueTimeActivity : AppCompatActivity() {

    private lateinit var mViewModel: FilaViewModel
    private lateinit var mShared: SecurityPreferences
    private lateinit var idRest: String
    private lateinit var idCliente: String

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

        mShared = SecurityPreferences(this)
        idRest = mShared.get(TaskConstants.SHAREDRESTAURANT.ID_RESTAURANTE)
        idCliente = mShared.get(TaskConstants.SHARED.ID_CLIENTE)

        val posicaoFila = intent.extras!!.getInt("posicao")
        posicao_fila.text = posicaoFila.toString()
        //Toast.makeText(this, "${posicaoFila}", Toast.LENGTH_LONG).show()

        Handler().postDelayed({
            val posicaoFila = intent.extras!!.getInt("posicao")
            posicao_fila.text = posicaoFila.toString()
            if (posicaoFila == 1) {
                val mDialogView =
                    LayoutInflater.from(this).inflate(R.layout.modal_queuetime, null);
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                //show dialog
                val mAlertDialog = mBuilder.show()
                //close modal
                val close: ImageView = mDialogView.findViewById(R.id.imgExit)
                close.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }
        },5000)

        // Toast.makeText(this, "Você entrou na fila com sucesso!!", Toast.LENGTH_LONG).show()


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigationFila -> {
                    val intent = Intent(this, QueueTimeActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigationRestaurant -> {
                    val intent2 = Intent(this, UserHomePageActivity::class.java)
                    startActivity(intent2)
                    true
                }
                else -> false
            }
        }
    }

//    private fun posicaoFila(idRest: String, idCliente: String) {
//        FilaViewModel().atualizaPosicao(idRest, idCliente)
//    }
}


