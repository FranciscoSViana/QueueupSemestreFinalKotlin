package com.example.queueup.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.queueup.R

class FilaInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fila_info)
        setSupportActionBar(findViewById(R.id.toolbarFila))

        val mySpinner: Spinner = findViewById(R.id.spinner_fila)
        var myArrayAdap: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            getResources().getStringArray(R.array.num_pessoasMesas)
        )
        myArrayAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.setAdapter(myArrayAdap)

    }
}
