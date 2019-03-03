package com.example.jonas.photo_list_app_task.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.adapter.AlbumAdapter
import com.example.jonas.photo_list_app_task.constant.Constant
import com.example.jonas.photo_list_app_task.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_album.*

class AlbumActivity : AppCompatActivity() {

    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        init()
        getAlbumsToRecyclerView()
    }

    private fun init(){
        album_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }

    private fun getAlbumsToRecyclerView(){
        try {
            ViewModel.getAlbums().observe(this, Observer {
                albumAdapter = AlbumAdapter(it!!)
                album_recyclerview.adapter = albumAdapter
            })
        }
        catch(e : Exception) {

        }
    }

    fun goToPhotoActivity(albumId: String){
        val intent = Intent(this, PhotosActivity::class.java)
        intent.putExtra(Constant.EXTRA_BUNDLE, albumId)
        startActivity(intent)
    }
}
