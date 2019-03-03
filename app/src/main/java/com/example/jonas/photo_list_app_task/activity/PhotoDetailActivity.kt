package com.example.jonas.photo_list_app_task.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.constant.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_photo_detail.*
import kotlinx.android.synthetic.main.default_toolbar.*

class PhotoDetailActivity : AppCompatActivity() {

    private lateinit var photoUrl:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)
        setSupportActionBar(default_toolbar)
        supportActionBar?.setTitle(R.string.photosDetail_toolbar_title)
        photoDetails_progressBar.visibility = View.VISIBLE
        photoDetails_image.visibility = View.GONE
        photoDetails_text_title.visibility = View.GONE
        init()
    }

    private fun init(){
        try {
            photoDetails_progressBar.visibility = View.GONE
            photoDetails_image.visibility = View.VISIBLE
            photoDetails_text_title.visibility = View.VISIBLE

            photoUrl = intent.getStringExtra(Constant.EXTRA_BUNDLE)
            Picasso.with(this).load(photoUrl).into(photoDetails_image)
        }
        catch(e : Exception) {
            Toast.makeText(this, R.string.loading_data_failed, Toast.LENGTH_SHORT).show()
        }

    }
}
