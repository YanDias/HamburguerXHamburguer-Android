package com.yan.HamburguerXHamburguer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yan.HamburguerXHamburguer.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCardapio.setOnClickListener{
            val intent = Intent(this, ListaLanchesActivity::class.java )
            startActivity(intent)
        }

    }
}
