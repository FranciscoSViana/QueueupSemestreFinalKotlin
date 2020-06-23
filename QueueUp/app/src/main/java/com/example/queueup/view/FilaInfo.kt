package com.example.queueup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.queueup.R
import kotlinx.android.synthetic.main.activity_fila_info.*

class FilaInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fila_info)
//        setSupportActionBar(findViewById(R.id.toolbarFila))

        val mySpinner: Spinner = findViewById(R.id.spinner_fila)
        var myArrayAdap: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            getResources().getStringArray(R.array.num_pessoasMesas)
        )
        myArrayAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.setAdapter(myArrayAdap)

        bt_fila.setOnClickListener {
            Toast.makeText(this, "Você entrou na fila com sucesso!!", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, QueueTimeActivity::class.java))
        }

    }
}
