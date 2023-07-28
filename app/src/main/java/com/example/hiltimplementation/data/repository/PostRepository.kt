package com.example.hiltimplementation.data.repository

import com.example.hiltimplementation.data.model.Post
import com.example.hiltimplementation.data.remote.PostAPI
import com.example.hiltimplementation.utills.Response
import javax.inject.Inject


class PostRepository @Inject constructor(private val apiService: PostAPI) : IPostRepository {
    override suspend fun getPost(): Response<List<Post>> {
        return try {
            val response = apiService.getPosts()
            if (response.isSuccessful && response.body() != null) {
                Response.Success(response.body()!!)
            } else {
                Response.Error(response.message() ?: "Something went wrong !!")
            }
        } catch (e: Exception) {
            Response.Error("An error occurred: ${e.message}")
        }
    }
}