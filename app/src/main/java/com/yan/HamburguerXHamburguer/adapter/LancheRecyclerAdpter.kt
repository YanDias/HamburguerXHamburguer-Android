package com.yan.HamburguerXHamburguer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hamburguerxhamburguer.db.Lanche
import com.yan.HamburguerXHamburguer.R
import kotlinx.android.synthetic.main.lanche_lista.view.*

class LancheRecyclerAdpter ():
        RecyclerView.Adapter<LancheRecyclerAdpter.ViewHolder>() {

    var onItemClickListener: ((Lanche) -> Unit)? = null

    // Cria Lista
    private var lancheList = emptyList<Lanche>()

    //Aumenta o Recycler View
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lanche_lista, parent, false)
        return ViewHolder(view)
    }
    //Tamanho Lista
    override fun getItemCount(): Int = lancheList.count()

    //insere os elementos
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lanche = lancheList[position]
        holder.txt_descricao.text = "\n"+lanche.descricao.toString()
        holder.txt_Preco.text="R$"+lanche.preco.toString()
        holder.txt_Quantidade.text=lanche.quantidade.toString()
        holder.txt_Nome.text="Nome: "+ lanche.nome
        holder.txt_Tipo.text=lanche.tipo
    }
    //atualiza dados
    fun setLancheList(lanches:List<Lanche> ){
        this.lancheList = lanches
        notifyDataSetChanged()
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {



        init {
            itemView.setOnClickListener{
                  onItemClickListener?.invoke(lancheList[adapterPosition])
            }
        }
        val txt_descricao: TextView = view.txtDescricao
        val txt_Preco:TextView=view.txtPreco
        val txt_Quantidade:TextView=view.txtQuantidade
        val txt_Tipo:TextView=view.txttipo
        val txt_Nome:TextView=view.txtNome
    }
}
