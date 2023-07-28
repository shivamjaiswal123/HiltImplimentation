package com.example.hiltimplementation.data.remote

import com.example.hiltimplementation.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostAPI {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}