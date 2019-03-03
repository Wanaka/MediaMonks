package com.example.jonas.photo_list_app_task.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.activity.PhotosActivity
import com.example.jonas.photo_list_app_task.model.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_photos_recyclerview_item.view.*

class PhotosAdapter (private val photosList: List<Photos>): RecyclerView.Adapter<PhotosAdapter.ItemHolder>() {

    lateinit var context: Context

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(currentItem: Photos) {
            Picasso.with(context).load(currentItem.thumbnailUrl).into(itemView.photos_image)
            itemView.setOnClickListener {
                (context as PhotosActivity).goToPhotoDetailsActivity(currentItem.url)
            }
        }
    }

    override fun onBindViewHolder(holder: PhotosAdapter.ItemHolder, position: Int) {
        val currentItem: Photos = photosList[position]
        holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosAdapter.ItemHolder {
        context = parent.context
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.layout_photos_recyclerview_item, parent, false))
    }

    override fun getItemCount() = photosList.size
}