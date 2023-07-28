package com.example.hiltimplementation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltimplementation.data.model.Post
import com.example.hiltimplementation.data.repository.IPostRepository
import com.example.hiltimplementation.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val postRepo: IPostRepository): ViewModel() {
    private val _post: MutableLiveData<List<Post>> = MutableLiveData()
    val post : LiveData<List<Post>> get() = _post

    init {
        fetchPost(postRepo)
    }

    private fun fetchPost(postRepo: IPostRepository) {
        viewModelScope.launch {
            postRepo.getPost().let {
                _post.postValue(it)
            }
        }
    }
}