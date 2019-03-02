package com.example.jonas.photo_list_app_task.api

import com.example.jonas.photo_list_app_task.model.Album
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>
}