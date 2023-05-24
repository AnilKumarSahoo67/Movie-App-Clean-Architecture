package com.aks.movieappcleanarchitecture.presentation.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aks.movieappcleanarchitecture.R
import com.aks.movieappcleanarchitecture.data.model.Articles
import com.aks.movieappcleanarchitecture.data.model.Results
import com.bumptech.glide.Glide

class NowPlayingAdapter :  RecyclerView.Adapter<NowPlayingAdapter.NowPlayingViewHolder>(){


    val differ = AsyncListDiffer(this,object : DiffUtil.ItemCallback<Results>(){
        override fun areItemsTheSame(
            oldItem: Results,
            newItem: Results
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Results,
            newItem: Results
        ): Boolean {
            return oldItem == newItem
        }

    })

    private var onClickCallBack:((Results, Int)->Unit)?=null

    fun onItemClickCallBack(callBack : (Results,Int)->Unit){
        this.onClickCallBack = callBack
    }

    inner class NowPlayingViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageView : ImageView = itemView.findViewById(R.id.imageViewNowPlaying)
        fun bind(result: Results, position: Int) {
            Glide.with(imageView.context).load("https://image.tmdb.org/t/p/original${result.poster_path}").into(imageView)

            itemView.setOnClickListener {
                onClickCallBack?.invoke(result,position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        return NowPlayingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.nowplaying_layouts,parent,false))
    }

    override fun getItemCount(): Int {
        return if(differ.currentList.size>10){
            10
        }else{
            differ.currentList.size
        }
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        holder.bind(differ.currentList[position],position)
    }
}