package com.selva.movie.ui.popular_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.selva.movie.R
import com.selva.movie.ui.single_movie_details.SingleMovie

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    lateinit var movieRepository: MoviePagedListRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun getViewModel(): MainActivityViewModel{
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory{
            override fun<T: ViewModel?> create(modelClass: Class<T>): T{
                @Suppress("UNCHECKED CAST")
                return MainActivityViewModel(movieRepository) as T
            }
        })[MainActivityViewModel::class.java]
    }
}