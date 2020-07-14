package com.yan.HamburguerXHamburguer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hamburguerxhamburguer.db.HelperDatabase
import com.example.hamburguerxhamburguer.db.Lanche
import com.yan.HamburguerXHamburguer.repository.LacheRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LancheViewModel(application: Application):
    AndroidViewModel(application) {

    private val parentJob = Job()
    private val corountineContext: CoroutineContext
    get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(corountineContext)

    private val repository: LacheRepository
    val allLanches: LiveData<List<Lanche>>

    init {
        val lancheDao = HelperDatabase.getDatabase(application).lancheDao()
        repository = LacheRepository(lancheDao)
        allLanches = repository.allLanches
    }

    fun insert(lanche: Lanche) = scope.launch(Dispatchers.IO){
        repository.insert(lanche)
    }

    fun update(lanche: Lanche) = scope.launch(Dispatchers.IO){
        repository.update(lanche)
    }

    fun delete(lanche: Lanche) = scope.launch(Dispatchers.IO){
        repository.delete(lanche)
    }
}