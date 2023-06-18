package com.example.chenifargan_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var numberViewModel: NumberViewModel
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        val apiService =RetrofitClient.numberApiService
        val repository= NumberRepository(apiService)
        val viewModelFactory = NumberViewModelFactory(repository)
        numberViewModel =ViewModelProvider(this,viewModelFactory).get(NumberViewModel::class.java)
        adapter = MyAdapter(mutableListOf())
        recyclerView.layoutManager = GridLayoutManager(this,3)


        recyclerView.adapter =adapter

        numberViewModel.fetchNumbers()




        numberViewModel.numbers.observe(this,{ numbers ->
         adapter.submitList(numbers)
        })




    }
}