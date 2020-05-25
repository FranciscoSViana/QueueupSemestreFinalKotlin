package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.queueup.R
import com.example.queueup.viewmodel.RegisterUserViewModel
import kotlinx.android.synthetic.main.activity_register_option.*

class RegisterOptionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: RegisterUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_option)

        listeners()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.tvModalRestaurante) {
            startActivity(Intent(this, RegisterRestaurantActivity::class.java))
        } else if (v.id == R.id.tvModalUsuario) {
            startActivity(Intent(this, RegisterUserActivity::class.java))
        }
    }

    private fun listeners() {
        tvModalRestaurante.setOnClickListener(this)
        tvModalUsuario.setOnClickListener(this)
    }
}
