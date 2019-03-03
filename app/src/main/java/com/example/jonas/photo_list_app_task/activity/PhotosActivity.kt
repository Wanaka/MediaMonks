package com.example.jonas.photo_list_app_task.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jonas.photo_list_app_task.R
import com.example.jonas.photo_list_app_task.constant.Constant

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)
        val message:String = intent.getStringExtra(Constant.EXTRA_BUNDLE)

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
