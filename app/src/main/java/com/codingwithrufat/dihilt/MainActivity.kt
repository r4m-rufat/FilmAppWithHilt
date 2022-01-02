package com.codingwithrufat.dihilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingwithrufat.dihilt.adapters.RecyclerViewAdapter
import com.codingwithrufat.dihilt.models.ResponseItem
import com.codingwithrufat.dihilt.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerAdapter()

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.response.observe(this, { showList ->
            recyclerViewAdapter.updateTvShowList(showList as List<ResponseItem>)
        })

    }

    private fun setupRecyclerAdapter() {

        recyclerView = findViewById(R.id.recyclerView)
        recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
        }

    }


}