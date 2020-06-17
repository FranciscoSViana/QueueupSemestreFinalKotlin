package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.queueup.R

class RestaurantDetailsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.entrarFila) {
            startActivity(Intent(this, FilaInfo::class.java))
        }
//        else
////            if (v.id == R.id.cancelar) {
////            startActivity(Intent(this, RestaurantListActivity::class.java))
////        }
    }
}