package com.example.hiltimplementation.data.repository

import com.example.hiltimplementation.data.model.Post


interface IPostRepository {
    suspend fun getPost(): List<Post>?
}