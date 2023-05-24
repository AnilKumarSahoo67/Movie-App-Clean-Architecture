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
import com.bumptech.glide.Glide

class BreakingNewsAdapter : RecyclerView.Adapter<BreakingNewsAdapter.BreakingNewsViewHolder>() {

    val differ = AsyncListDiffer(this,object : DiffUtil.ItemCallback<Articles>(){
        override fun areItemsTheSame(
            oldItem: Articles,
            newItem: Articles
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Articles,
            newItem: Articles
        ): Boolean {
            return oldItem == newItem
        }

    })

    private var onClickCallBack:((Articles, Int)->Unit)?=null

    fun onItemClickCallBack(callBack : (Articles,Int)->Unit){
        this.onClickCallBack = callBack
    }
    inner class BreakingNewsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageView : ImageView = itemView.findViewById(R.id.ImageView)
        fun bind(articles: Articles?, position: Int) {
            Glide.with(imageView.context).load(articles?.urlToImage).centerCrop().placeholder(R.drawable.image).into(imageView)

            itemView.setOnClickListener {
                articles?.let {
                    onClickCallBack?.invoke(articles,position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        return BreakingNewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.banner_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return if(differ.currentList.size>10){
            10
        }else{
            differ.currentList.size
        }
    }

    override fun onBindViewHolder(holder: BreakingNewsViewHolder, position: Int) {
        holder.bind(differ.currentList[position],position)
    }
}