package com.example.jonas.photo_list_app_task.api

import com.example.jonas.photo_list_app_task.model.Album
import com.example.jonas.photo_list_app_task.model.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/albums")
    fun getAlbums(): Call<List<Album>>

    @GET("/albums/{albumId}/photos")
    fun getPhotos(
        @Query("albumId") albumId: String
    ): Call<List<Photos>>
}