package com.yan.HamburguerXHamburguer.repository

import androidx.lifecycle.LiveData
import com.example.hamburguerxhamburguer.db.Lanche
import com.example.hamburguerxhamburguer.db.LancheDAO

class LacheRepository(private  val lancheDao: LancheDAO) {
    val allLanches: LiveData<List<Lanche>> = lancheDao.getAll()

    fun insert(lanche: Lanche){
        lancheDao.insert(lanche)
    }

    fun update(lanche: Lanche){
        lancheDao.update(lanche)
    }

    fun delete(lanche: Lanche){
        lancheDao.delete(lanche)
    }
}