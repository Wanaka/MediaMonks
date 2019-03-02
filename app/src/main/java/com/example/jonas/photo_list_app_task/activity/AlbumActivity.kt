package com.example.jonas.photo_list_app_task.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.adapter.AlbumAdapter
import com.example.jonas.photo_list_app_task.model.Album
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        album_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val list: List<Album> = listOf(Album(1,1,"Hello"), Album(2,2,"World"))

        albumAdapter = AlbumAdapter(list)

        album_recyclerview.adapter = albumAdapter
    }
}
