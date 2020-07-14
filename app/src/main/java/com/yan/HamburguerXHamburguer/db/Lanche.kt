package com.example.hamburguerxhamburguer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "lanche_tb")
class Lanche (
    @ColumnInfo(name = "nome_cl")
    var nome: String = "",

    @ColumnInfo(name = "tipo_cl")
    var tipo: String = "",

    @ColumnInfo(name = "desc_cl")
    var descricao: String = "",

    @ColumnInfo(name = "preco_cl")
    var preco: Double = 0.0,

    @ColumnInfo(name = "quantidade_cl")
    var quantidade: Int = 0

    ): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}





