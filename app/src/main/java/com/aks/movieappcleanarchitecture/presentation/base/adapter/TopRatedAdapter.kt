package com.aks.movieappcleanarchitecture.presentation.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aks.movieappcleanarchitecture.R
import com.aks.movieappcleanarchitecture.data.model.Results
import com.bumptech.glide.Glide

class TopRatedAdapter :  RecyclerView.Adapter<TopRatedAdapter.TopRatedViewHolder>() {


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
    inner class TopRatedViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageView : ImageView = itemView.findViewById(R.id.ImageView)
        fun bind(result: Results?, position: Int) {
            Glide.with(imageView.context).load("https://image.tmdb.org/t/p/original${result?.poster_path}").into(imageView)

            itemView.setOnClickListener {
                result?.let {res->
                    onClickCallBack?.invoke(res,position)
                }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.banner_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return if(differ.currentList.size>10){
            12
        }else{
            differ.currentList.size
        }
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(differ.currentList[position],position)
    }
}