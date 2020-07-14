package com.yan.HamburguerXHamburguer.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hamburguerxhamburguer.db.Lanche
import com.yan.HamburguerXHamburguer.R
import com.yan.HamburguerXHamburguer.adapter.LancheRecyclerAdpter
import com.yan.HamburguerXHamburguer.viewmodel.LancheViewModel
import kotlinx.android.synthetic.main.activity_lista_lanches.*
import java.lang.Exception

class ListaLanchesActivity : AppCompatActivity() {
    private  lateinit var lancheViewModel: LancheViewModel
    private lateinit var  recyclerLanche: RecyclerView
    val REQUEST_CODE = 12


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_lanches)

        recyclerLanche = recyclerViewLanche
        Lista(recyclerLanche)

        val intent = Intent(this, Cadastro_Activity::class.java)

        intent?.let { resultado ->
            try{
                //Recebe Objeto
                val lanche: Lanche = resultado.extras?.
                    get(Cadastro_Activity.EXTRA_REPLY) as Lanche

                // Envia Objeto
                lanche.let {
                    lancheViewModel.insert(lanche)
                }
            } catch (e: Exception){
                Log.d("TAG: ", e.message)
            }
        }

        btnNovofb.setOnClickListener {
            val intent = Intent(this, Cadastro_Activity::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            data?.let { resultado ->
                try{
                    //Recebe Objeto
                    val lanche: Lanche = resultado.extras?.
                        get(Cadastro_Activity.EXTRA_REPLY) as Lanche

                    // Envia Objeto
                    lanche.let {
                        lancheViewModel.insert(lanche)
                    }
                } catch (e: Exception){
                    Log.d("TAG: ", e.message)
                }
            }


    }

    private fun Lista(recyclerLanche: RecyclerView) {

        val adapter = LancheRecyclerAdpter()
        recyclerLanche.adapter = adapter
        recyclerLanche.layoutManager = LinearLayoutManager(this)

        lancheViewModel = ViewModelProviders.of(this).get(LancheViewModel::class.java)

        lancheViewModel.allLanches.observe(this, Observer { list -> list?.let{adapter.setLancheList(it)} })
    }

    override fun onRestart() {
        super.onRestart()

        Lista(recyclerLanche)

    }
}
