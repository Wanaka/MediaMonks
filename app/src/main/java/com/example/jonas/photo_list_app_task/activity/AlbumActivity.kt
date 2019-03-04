package com.example.jonas.photo_list_app_task.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.adapter.AlbumAdapter
import com.example.jonas.photo_list_app_task.constant.Constant
import com.example.jonas.photo_list_app_task.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_album.*
import kotlinx.android.synthetic.main.default_toolbar.*

class AlbumActivity : AppCompatActivity() {

    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        setSupportActionBar(default_toolbar)
        supportActionBar?.setTitle(R.string.album_toolbar_title)

        init()
        getAlbumsToRecyclerView()
    }

    private fun init(){
        album_progressBar.visibility = View.VISIBLE
        album_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
    }

    private fun getAlbumsToRecyclerView(){
        try {
            ViewModel.getAlbums().observe(this, Observer {
                album_progressBar.visibility = View.GONE
                albumAdapter = AlbumAdapter(it!!)
                album_recyclerview.adapter = albumAdapter
            })
        }
        catch(e : Exception) {
            Toast.makeText(this, R.string.loading_data_failed, Toast.LENGTH_SHORT).show()
        }
    }

    fun goToPhotoActivity(albumId: String){
        val intent = Intent(this, PhotosActivity::class.java)
        intent.putExtra(Constant.EXTRA_BUNDLE, albumId)
        startActivity(intent)
    }
}
