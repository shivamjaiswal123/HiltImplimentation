package com.example.hiltimplementation.data.repository

import com.example.hiltimplementation.data.model.Post
import com.example.hiltimplementation.utills.Response


interface IPostRepository {
    suspend fun getPost(): Response<List<Post>>
}