package com.example.jonas.photo_list_app_task.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.jonas.photo_list_app_task.api.ApiInterface
import com.example.jonas.photo_list_app_task.constant.Constant
import com.example.jonas.photo_list_app_task.model.Album
import com.example.jonas.photo_list_app_task.model.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    var albumsList: MutableLiveData<List<Album>> = MutableLiveData()
    var photosList: MutableLiveData<List<Photos>> = MutableLiveData()

    fun getAlbums(): LiveData<List<Album>> {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getAlbums().enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albumsList.value = response.body()
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
            }
        })

        return albumsList
    }

    fun getPhotos(albumId:String): LiveData<List<Photos>> {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getPhotos(albumId).enqueue(object : Callback<List<Photos>> {
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                photosList.value = response.body()
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
            }
        })

        return photosList
    }
}