package com.example.jonas.photo_list_app_task.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.adapter.PhotosAdapter
import com.example.jonas.photo_list_app_task.constant.Constant
import com.example.jonas.photo_list_app_task.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_photos.*

class PhotosActivity : AppCompatActivity() {

    private lateinit var photosAdapter: PhotosAdapter
    private lateinit var albumId:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        albumId = intent.getStringExtra(Constant.EXTRA_BUNDLE)

        init()
        getPhotosToRecyclerView()
    }

    private fun init(){
        photos_recyclerview.layoutManager =  GridLayoutManager(this, 2)
    }

    private fun getPhotosToRecyclerView(){
        try {
            ViewModel.getPhotos(albumId).observe(this, Observer {
                photosAdapter = PhotosAdapter(it!!)
                photos_recyclerview.adapter = photosAdapter
            })
        }
        catch(e : Exception) {

        }
    }

    fun goToPhotoDetailsActivity(albumId: String){
        val intent = Intent(this, PhotoDetailActivity::class.java)
        intent.putExtra(Constant.EXTRA_BUNDLE, albumId)
        startActivity(intent)
    }
}
