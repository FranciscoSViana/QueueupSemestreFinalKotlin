package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.queueup.R
import com.example.queueup.viewmodel.RegisterUserViewModel
import kotlinx.android.synthetic.main.activity_register_user.*

class RegisterUserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: RegisterUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        mViewModel = ViewModelProvider(this).get(RegisterUserViewModel::class.java)

        listeners()
        observe()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {

            val name = edit_name.text.toString()
            val cpf = edit_cpf.text.toString()
            val password = edit_password.text.toString()

            mViewModel.create(name, cpf, password)
        }
    }

    private fun observe() {
        mViewModel.create.observe(this, Observer {
            if (it.success()) {
                startActivity(Intent(this, UserHomePageActivity::class.java))
            } else {
                Toast.makeText(applicationContext, it.failure(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun listeners() {
        button_save.setOnClickListener(this)
    }
}
