package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.queueup.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class QueueTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue_time)
        setSupportActionBar(findViewById(R.id.toolbar_userhomepage))
        //configurações do menu
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation).also {
            it.selectedItemId = R.id.navigationFila

        }

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