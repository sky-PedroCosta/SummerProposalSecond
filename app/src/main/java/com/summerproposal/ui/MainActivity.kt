package com.summerproposal.ui

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.summerproposal.databinding.ActivityMainBinding
import com.summerproposal.ui.MainState.*
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: VerticalList_RVAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = VerticalList_RVAdapter()
        binding.rvPeacockData.layoutManager = LinearLayoutManager(this)
        binding.rvPeacockData.adapter = adapter

        viewModel.res.observe(this, {
            when(it){
                is Success -> {
                    adapter.submitList(it.data.relationships.items.items)

                    binding.progressBar.visibility = View.GONE
                    binding.rvPeacockData.visibility = View.VISIBLE
                }
                is Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rvPeacockData.visibility = View.GONE
                }
                is Error -> {
                    Log.e(TAG, "Error : ${it.message}")
                    Snackbar.make(binding.rootView, "Something went wrong", Snackbar.LENGTH_SHORT).show()
                }
                else -> {
                    Log.e(TAG,"Error : ")
                }
            }

        })

        fun sum(a: Int, b: Int) : Int{
            return a + b
        }

    }
}