package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.queueup.R
import com.example.queueup.service.model.EnderecoHeaderModel
import com.example.queueup.service.model.RestaurantHeaderModel
import com.example.queueup.viewmodel.RegisterRestaurantViewModel
import kotlinx.android.synthetic.main.activity_register_restaurant.*

class RegisterRestaurantActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: RegisterRestaurantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_restaurant)

        mViewModel = ViewModelProvider(this).get(RegisterRestaurantViewModel::class.java)

        listeners()
        observe()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.register_restaurant) {

            val razaoSocial = razao_social.text.toString()
            val cnpj = cnpj.text.toString()
            val telefone = telefone.text.toString()
            val cep = cep.text.toString()
            val country = estado.text.toString()
            val city = cidade.text.toString()
            val bairro = bairro.text.toString()
            val streets = endereco.text.toString()
            val number = numero.text.toString()
            val password = senha.text.toString()
            val especialidade = especialidade.text.toString()
            val endereco = EnderecoHeaderModel(city, country, bairro, streets, number, cep)
            val restaurante =
                RestaurantHeaderModel(
                    razaoSocial,
                    cnpj,
                    password,
                    endereco,
                    telefone,
                    especialidade,
                    null
                )


            mViewModel.create(restaurante)

        }
    }

    private fun observe() {
        mViewModel.create.observe(this, Observer {
            if (it.success()) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(applicationContext, it.failure(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun listeners() {
        register_restaurant.setOnClickListener(this)
    }
}
