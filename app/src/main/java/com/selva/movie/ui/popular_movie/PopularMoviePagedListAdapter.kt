package com.selva.movie.ui.popular_movie

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.selva.movie.data.api.POSTER_BASE_URL
import com.selva.movie.data.vobject.Movie

import android.content.Intent
import android.view.LayoutInflater
import androidx.core.content.ContextCompat.startActivity

import com.selva.movie.R
import com.selva.movie.data.api.POSTER_BASE_URL
import kotlinx.android.synthetic.main.movie_list_item.view.*
import com.selva.movie.data.repository.NetworkState
import com.selva.movie.data.repository.Status
import com.selva.movie.ui.single_movie_details.SingleMovie
import com.selva.movie.ui.single_movie_details.SingleMovieViewModel
import kotlinx.android.synthetic.main.network_state_item.view.*
class PopularMoviePagedListAdapter: PagedListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    class MovieDiffCallBack: DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }

    class MovieItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(movie: Movie?, context: Context){
            itemView.cv_movie_title.text = movie?.title
            itemView.cv_movie_release_date.text = movie?.releaseDate

            val moviePosterURL : String = POSTER_BASE_URL + movie?.posterPath
            Glide.with(itemView.context)
                .load(moviePosterURL)
                .into(itemView.cv_iv_movie_poster);


        }
    }
}