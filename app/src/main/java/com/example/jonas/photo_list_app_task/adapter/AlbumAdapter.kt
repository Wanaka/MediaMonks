package com.example.jonas.photo_list_app_task.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.activity.AlbumActivity
import com.example.jonas.photo_list_app_task.model.Album
import kotlinx.android.synthetic.main.layout_album_recyclerview.view.*

class AlbumAdapter (private val albumList: List<Album>): RecyclerView.Adapter<AlbumAdapter.ItemHolder>() {

    lateinit var context: Context

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(currentItem: Album) {
            itemView.album_text_title.text = currentItem.title
            itemView.setOnClickListener {
                (context as AlbumActivity).goToPhotoActivity(currentItem.id.toString())
            }
        }
    }

    override fun onBindViewHolder(holder: AlbumAdapter.ItemHolder, position: Int) {
        val currentItem: Album = albumList[position]
        holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumAdapter.ItemHolder {
        context = parent.context
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.layout_album_recyclerview, parent, false))
    }

    override fun getItemCount() = albumList.size
}