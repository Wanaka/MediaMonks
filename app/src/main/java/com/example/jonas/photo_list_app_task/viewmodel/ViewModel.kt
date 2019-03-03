package com.example.jonas.photo_list_app_task.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.jonas.photo_list_app_task.model.Album
import com.example.jonas.photo_list_app_task.model.Photos
import com.example.jonas.photo_list_app_task.repo.Repository

class ViewModel: ViewModel(){

    companion object {
        private val repo = Repository()

        fun getAlbums(): LiveData<List<Album>>{
            return repo.getAlbums()
        }

        fun getPhotos(albumId: String): LiveData<List<Photos>>{
            return repo.getPhotos(albumId)
        }
    }

}
