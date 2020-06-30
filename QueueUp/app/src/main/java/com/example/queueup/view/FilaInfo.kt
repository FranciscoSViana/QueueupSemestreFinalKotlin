package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.queueup.R
import com.example.queueup.service.constants.TaskConstants
import com.example.queueup.service.model.FilaHeaderModel
import com.example.queueup.service.repository.local.SecurityPreferences
import com.example.queueup.viewmodel.FilaViewModel
import kotlinx.android.synthetic.main.activity_fila_info.*
import java.util.*
import kotlin.concurrent.schedule

class FilaInfo : AppCompatActivity() {

    private lateinit var mViewModel: FilaViewModel
    private lateinit var mShared: SecurityPreferences
    private lateinit var idRest: String
    private lateinit var idCliente: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fila_info)
//        setSupportActionBar(findViewById(R.id.toolbarFila))
        val mSharedPreferences: SecurityPreferences = SecurityPreferences(applicationContext)
        mViewModel = ViewModelProviders.of(this).get(FilaViewModel::class.java)

        idRest = mSharedPreferences.get(TaskConstants.SHAREDRESTAURANT.ID_RESTAURANTE)
        idCliente = mSharedPreferences.get(TaskConstants.SHARED.ID_CLIENTE)


        val mySpinner: Spinner = findViewById(R.id.spinner_fila)
        var myArrayAdap: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            getResources().getStringArray(R.array.num_pessoasMesas)
        )
        myArrayAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.setAdapter(myArrayAdap)

        Handler().postDelayed({
            mViewModel.atualizaPosicao(idRest, idCliente, this)

        },25000)


        bt_fila.setOnClickListener {
            mShared = SecurityPreferences(this)
            val user = mShared.get(TaskConstants.SHARED.ID_CLIENTE)
            val iRest = mShared.get(TaskConstants.SHAREDRESTAURANT.ID_RESTAURANTE)
            mViewModel.entrarFila(FilaHeaderModel(user, iRest, 0))

            Handler().postDelayed({
            mViewModel.atualizaPosicao(iRest, user, this)

            },5000)

            //val intent = Intent(this, QueueTimeActivity::class.java)
            //intent.putExtra("posicao", posicao.toString().toInt())
            // startActivity(intent)
        }

        mShared = SecurityPreferences(this)
        val user = mShared.get(TaskConstants.SHARED.ID_CLIENTE)
        // val idRest = intent.extras!!.getString("idRest")


        // Toast.makeText(this, idRest, Toast.LENGTH_LONG).show()
        val qtdeFila = intent.extras!!.getInt("qtdFila")
        tv_minutos.text = qtdeFila.toString()
    }


}
