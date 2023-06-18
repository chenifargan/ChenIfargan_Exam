package com.example.chenifargan_exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NumberViewModelFactory(private val repository: NumberRepository): ViewModelProvider.Factory {

     override fun <T: ViewModel> create(modelClass: Class<T>):T {
        if (modelClass.isAssignableFrom(NumberViewModel::class.java)) {
            return NumberViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Error")
    }

}