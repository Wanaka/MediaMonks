package com.example.jonas.photo_list_app_task.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.adapter.PhotosAdapter
import com.example.jonas.photo_list_app_task.constant.Constant
import com.example.jonas.photo_list_app_task.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_photos.*
import kotlinx.android.synthetic.main.default_toolbar.*

class PhotosActivity : AppCompatActivity() {

    private lateinit var photosAdapter: PhotosAdapter
    private lateinit var albumId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        setSupportActionBar(default_toolbar)
        supportActionBar?.setTitle(R.string.photos_toolbar_title)

        init()
        getPhotosToRecyclerView()
    }

    private fun init(){
        photos_recyclerview.layoutManager =  GridLayoutManager(this, 2)
        photos_progressBar.visibility = View.VISIBLE
        albumId = intent.getStringExtra(Constant.EXTRA_BUNDLE)
    }

    private fun getPhotosToRecyclerView(){
        try {
            ViewModel.getPhotos(albumId).observe(this, Observer {
                photos_progressBar.visibility = View.GONE
                photosAdapter = PhotosAdapter(it!!)
                photos_recyclerview.adapter = photosAdapter
            })
        }
        catch(e : Exception) {
            Toast.makeText(this, R.string.loading_data_failed, Toast.LENGTH_SHORT).show()
        }
    }

    fun goToPhotoDetailsActivity(photoUrl: String){
        val intent = Intent(this, PhotoDetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_BUNDLE, photoUrl)
        startActivity(intent)
    }
}
