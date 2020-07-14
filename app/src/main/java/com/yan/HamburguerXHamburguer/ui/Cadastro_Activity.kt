package com.yan.HamburguerXHamburguer.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.hamburguerxhamburguer.db.Lanche
import com.yan.HamburguerXHamburguer.R
import kotlinx.android.synthetic.main.activity_cadastro_.*

class Cadastro_Activity : AppCompatActivity() {
    lateinit var lanche: Lanche
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_)


        PopularSpinner()

    }

    fun salvar(view: View){
        val tipo = spTipo.selectedItem.toString()
        if (txtDecricao.text.isNullOrEmpty() || txtNome.text.isNullOrEmpty() || txtPreco.text.isNullOrEmpty()||txtQuantidade.text.isNullOrEmpty()|| tipo.isNullOrEmpty()) {
            Toast.makeText(
                this,
                "Todos os Campos Devem estar Preenchidos",
                Toast.LENGTH_LONG
            ).show()
        }
        else{
            lanche = Lanche()
            prLanche()

            var intent = Intent()

            //Passa o objeto a ser cadastrado
            intent.putExtra(EXTRA_REPLY,lanche)

            setResult(Activity.RESULT_OK, intent)

            finish()

            Toast.makeText(
                this,
                "Dados Cadastrados Com Sucesso",
                Toast.LENGTH_LONG
            ).show()
        }


    }

    private fun prLanche(){
        lanche.quantidade =txtQuantidade.text.toString().toInt()
        lanche.tipo= spTipo.selectedItem.toString()
        lanche.preco=txtPreco.text.toString().toDouble()
        lanche.nome=txtNome.text.toString()
        lanche.descricao = txtDecricao.text.toString()
    }

    fun PopularSpinner(){

        val activity_list = arrayOf(
            "",
            "Pizza",
            "Porção",
            "Hamburguer",
            "Combo",
            "Salgado",
            "Pastel")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            activity_list)

        //Adicionar o modelo dos dados com os dados no adapter do spinner
        spTipo.adapter = adapter

    }

    companion object{
        const val  EXTRA_REPLY ="com.yan.HamburguerXHamburguer.ui.REPLY"

    }
}



