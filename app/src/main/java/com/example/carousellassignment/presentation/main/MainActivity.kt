package com.example.carousellassignment.presentation.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carousellassignment.R
import com.example.carousellassignment.databinding.ActivityMainBinding
import com.example.carousellassignment.databinding.ItemNewsBinding
import com.example.carousellassignment.presentation.adapter.NewsAdapter
import com.example.carousellassignment.presentation.main.viewmodel.NewsViewModel
import com.example.myapplication.data.network.model.NewsNetwork
import com.example.myapplication.utils.NewsFilterType
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter
    private val viewmodel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsAdapter = NewsAdapter()
        setSupportActionBar(binding.toolbar)
        setupRecyclerView()
        setupObservers()
        selectedNews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_menu -> {
                showSortMenu()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupRecyclerView() {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
    }

    private fun selectedNews() {
        newsAdapter.setUserListener(object : NewsAdapter.NewsListener {
            override fun onItemClick(itemNewsBinding: ItemNewsBinding, news: NewsNetwork?) {
                Toast.makeText(
                    itemNewsBinding.cvNews.context,
                    "News rank ${news?.rank} clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun setupObservers() {
        viewmodel.listNewsLiveData().observe(this) {
            newsAdapter.saveData(it)
        }
        viewmodel.errorListNewsLiveData().observe(this) {
            Snackbar.make(binding.root, it.toString(), Snackbar.LENGTH_SHORT).show()
        }
        viewmodel.getIsLoading().observe(this) {
            showLoading(it)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.layoutLoading.progressLoading.isVisible = isLoading
    }

    private fun showSortMenu() {
        val view = findViewById<View>(R.id.action_menu) ?: return
        PopupMenu(this, view).apply {
            menuInflater.inflate(R.menu.menu_sort, menu)
            setOnMenuItemClickListener {
                viewmodel.setFilterType(
                    when (it.itemId) {
                        R.id.action_recent -> NewsFilterType.RECENT
                        R.id.action_popular -> NewsFilterType.POPULAR
                        else -> NewsFilterType.RECENT
                    }
                )
                true
            }
            show()
        }
    }
}