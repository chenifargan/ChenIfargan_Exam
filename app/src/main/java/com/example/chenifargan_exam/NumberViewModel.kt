package com.example.chenifargan_exam

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NumberViewModel(private  val repository: NumberRepository) :ViewModel() {
    private val numbersData = MutableLiveData<List<Numbers>>()
    val numbers:LiveData<List<Numbers>> get()= numbersData



     fun fetchNumbers(){
        viewModelScope.launch {
            try{
              val sortedNumbers = repository.getSortedNumbers()
                numbersData.value = sortedNumbers

                }


            catch (e: Exception){
                Log.d("chen",e.toString())
            }

        }
    }
}