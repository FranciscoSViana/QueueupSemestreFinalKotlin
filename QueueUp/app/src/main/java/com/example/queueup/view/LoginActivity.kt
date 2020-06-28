package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.queueup.R
import com.example.queueup.utils.SaveData
import com.example.queueup.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: LoginViewModel
    private lateinit var mSharedPreferences: SaveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //Inicializa eventos
        setListeners()
        observe()

        //Verifica se o usuário está logado
        verifyLoggedUser()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_login) {
            handleLogin()
        } else if (v.id == R.id.button_register) {
            startActivity(Intent(this, RegisterUserActivity::class.java))
            // startActivity(Intent(this, QueueTimeActivity::class.java))

            //Para aparecer o modal
            /*val mDialogView = LayoutInflater.from(this).inflate(R.layout.modal_queuetime, null);
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
            //show dialog
            val mAlertDialog = mBuilder.show()
            //close modal
            val close: ImageView = mDialogView.findViewById(R.id.imgExit)
            close.setOnClickListener{
                mAlertDialog.dismiss()
            }*/

        }
    }

    //Inicializa os eventos de Click
    private fun setListeners() {
        button_login.setOnClickListener(this)
        button_register.setOnClickListener(this)
    }

    //Verifica se o usuário está logado

    private fun verifyLoggedUser() {
        mViewModel.verifyLoggedUser()
    }

    //Observa a ViewModel
    private fun observe() {
        mViewModel.login.observe(this, Observer {
            if (it.success()) {
                startActivity(Intent(this, UserHomePageActivity::class.java))
            } else {
                val message = it.failure()
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        })

        mViewModel.loggedUser.observe(this, Observer {
            if (it) {
                startActivity(Intent(this, UserHomePageActivity::class.java))
            }
        })
    }

    //Autentica usuário
    private fun handleLogin() {
        val cpf = edit_cpf.text.toString()
        val password = edit_password.text.toString()

        val res = mViewModel.doLogin(cpf, password)

//        mSharedPreferences = SaveData(this)
//        val str = mSharedPreferences.get()
//
//        Toast.makeText(this, "${str}", Toast.LENGTH_LONG).show()
    }
}
