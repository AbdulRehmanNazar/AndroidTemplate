package com.android.androidtemplate.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidtemplate.R
import com.android.androidtemplate.data.local.AppDataBase
import com.android.androidtemplate.data.model.User
import com.android.androidtemplate.interfaces.AdapterItemClick
import com.android.androidtemplate.ui.main.adapter.MainAdapter
import com.android.androidtemplate.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
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
        mainViewModel.getUsersLocalDB().observe(this) { userList -> renderList(userList) }
    }

    private fun renderList(users: List<User>) {
        Toast.makeText(this@MainActivity, "Data rendered", Toast.LENGTH_SHORT).show()
        Log.d("Abdul", "renderList: " + users.size)
        adapter.setData(users)
        adapter.notifyDataSetChanged()
    }

}