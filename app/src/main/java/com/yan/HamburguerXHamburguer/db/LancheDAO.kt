package com.example.hamburguerxhamburguer.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LancheDAO {

    @Insert
    fun insert(lanche: Lanche)

    @Update
    fun update(lanche: Lanche)

    @Delete
    fun delete(lanche: Lanche)

    @Query("SELECT * FROM lanche_tb ORDER BY nome_cl ASC")
    fun getAll():LiveData<List<Lanche>>

    @Query("SELECT * FROM lanche_tb  WHERE id = :id_")
    fun getByID(id_: Int): LiveData<Lanche>

    @Query("DELETE FROM lanche_tb")
    fun deleteAll()
}