package com.example.hiltimplementation.data.repository

import com.example.hiltimplementation.data.model.Post
import com.example.hiltimplementation.data.remote.PostAPI
import javax.inject.Inject


class PostRepository @Inject constructor(private val apiService: PostAPI): IPostRepository{
    override suspend fun getPost(): List<Post>? {
        return try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}