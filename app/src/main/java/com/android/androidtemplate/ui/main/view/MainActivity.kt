package com.android.androidtemplate.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidtemplate.R
import com.android.androidtemplate.data.api.ApiHelper
import com.android.androidtemplate.data.api.ApiServiceImpl
import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.interfaces.AdapterItemClick
import com.android.androidtemplate.ui.main.adapter.MainAdapter
import com.android.androidtemplate.ui.main.viewmodel.MainViewModel
import com.android.androidtemplate.ui.main.viewmodel.ViewModelFactory
import com.android.androidtemplate.utils.Status

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setUpViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf(), object : AdapterItemClick<User> {
            override fun onItemClick(item: User?, position: Int, type: String) {
                Toast.makeText(this@MainActivity, item?.name, Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let {
                        renderList(it)
                    }

                }
                Status.FAILURE -> {
                    progressBar.visibility = View.GONE
                    Log.d("", it.message.toString())
                }
            }
        })
    }

    private fun renderList(users: List<User>) {
        adapter.setData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProviders.of(this, ViewModelFactory(ApiHelper(ApiServiceImpl())))
            .get(MainViewModel::class.java)
    }
}